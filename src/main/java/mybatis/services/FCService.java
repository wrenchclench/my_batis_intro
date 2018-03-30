package mybatis.services;

import mybatis.mappers.fc.FCMapper;
import mybatis.model.fc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FCService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FCMapper fcMapper;

    @Autowired
    WatsonService watsonService;


    // Access FullContact API via a given email address
    public PersonSummary searchByEmail(String query, boolean persist) {

        String fQuery = "https://api.fullcontact.com/v2/person.json?email=" + query + "&apiKey=YOURAPIKEY";

        PersonSummary response = restTemplate.getForObject(fQuery, PersonSummary.class);

        //Push returned data to DB from Summary Search object
        if (persist) {
            insertContact(convertToDBSummary(response));
        }

        insertTopics(response);
        //pullSocialUrl(response);
        //watsonService.classifyImages(pullSocialUrl(response));

        return response;
    }

    // Method to insert data into DB
    public void insertContact(SearchSummary result) {
        fcMapper.insertContact(result);
    }

    // Method to pull Full Name, City and Country into Search Summary object
    public SearchSummary convertToDBSummary(PersonSummary result) {

        SearchSummary obj = new SearchSummary();

        obj.setCity(result.getDemographics().getLocationDeduced().getCity().getName());
        obj.setCountry(result.getDemographics().getLocationDeduced().getCountry().getName());
        obj.setFullName(result.getContactInfo().getFullName());

        return obj;
    }

    // Check DB to see if returned Topic already exists, if not insert new Topic to SQL Table fullcontact_topics
    public Topics[] insertTopics(PersonSummary result){

        Topics[] topicArray = result.getDigitalFootprint().getTopics();

        for (Topics t : topicArray){

            TopicSummary obj = new TopicSummary();

            obj.setTopic(t.getValue());

            if (fcMapper.selectTopic(obj.getTopic()) == null){
                fcMapper.insertTopic(obj);
            }
        }
        return topicArray;
    }

    public SocialPhotoUrl pullSocialUrl(PersonSummary result){

        Photos[] photosArray = result.getPhotos();

        SocialPhotoUrl obj = null;

        for (Photos p : photosArray){

            obj = new SocialPhotoUrl();

            if ((p.getTypeName().compareTo("Facebook") == 1)){
                obj.setImageUrl(p.getUrl());
            }
        }
        System.out.println(obj.getImageUrl());
        return obj;
    }

}

