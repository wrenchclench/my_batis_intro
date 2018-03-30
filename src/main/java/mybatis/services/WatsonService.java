package mybatis.services;

import mybatis.model.fc.SocialPhotoUrl;
import mybatis.model.ibmVisualRec.ClassifiedImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WatsonService {

    @Autowired
    RestTemplate restTemplate;

    // Access Watson Visual Image Classifier API
    public ClassifiedImages classifyImages(ClassifiedImages profileImageUrl) {

        String fQuery = "https://watson-api-explorer.mybluemix.net/visual-recognition/api/v3/classify?api_key=YOURAPIKEY&url="+profileImageUrl+"&owners=IBM&threshold=0.5&version=2016-05-20";

        ClassifiedImages response = restTemplate.getForObject(fQuery, ClassifiedImages.class);

        return response;
    }
}
