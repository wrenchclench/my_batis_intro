package mybatis.services;

import mybatis.mappers.fc.FCMapper;
import mybatis.model.fc.PersonSummary;
import mybatis.model.fc.SearchSummary;
import mybatis.model.fc.TopicSummary;
import mybatis.model.fc.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FCService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FCMapper fcMapper;


    // Access FullContact API via a given email address
    public PersonSummary searchByEmail(String query, boolean persist) {

        String fQuery = "https://api.fullcontact.com/v2/person.json?email=" + query + "&apiKey=";

        PersonSummary response = restTemplate.getForObject(fQuery, PersonSummary.class);

        //Push returned data to DB from Summary Search object
        if (persist) {
            insertContact(convertToDBSummary(response));
        }

        insertTopics(response);

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

}

