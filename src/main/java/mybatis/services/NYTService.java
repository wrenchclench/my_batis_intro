package mybatis.services;


import mybatis.mappers.nyt.NYTMapper;
import mybatis.model.nyt.external.NYTDocs;
import mybatis.model.nyt.external.NYTRoot;
import mybatis.model.nyt.challenges.ResponseComparison;
import mybatis.model.nyt.internal.NYTOverview;
import mybatis.threads.NYTOverviewThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// class NYTService
    @Service
    public class NYTService {

        @Autowired
        RestTemplate restTemplate;

        @Autowired
        NYTMapper nytMapper;

        public NYTRoot searchNYT(String query, boolean persist) {
            String fQuery = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q="+query+"&api-key=";

            NYTRoot response = restTemplate.getForObject(fQuery, NYTRoot.class);

            System.out.println("*****GOT RESULTS****");

            if (persist){
                System.out.println("*******STARTING PERSISTANCE THREAD******");

                NYTOverviewThread thread = new NYTOverviewThread(response);

            }
            System.out.println("RETURNING RESPONSE");
            return response;
        }

    public ResponseComparison compareNYTResults(String t1, String t2) {

            NYTRoot responseOne = searchNYT(t1, false);
            NYTRoot responseTwo = searchNYT(t2, false);

            ResponseComparison obj = new ResponseComparison();

            //Set the first term in the response comparison
            obj.setSearchTermOne(t1);
            //Set the second term in the response comparison
            obj.setSearchtermTwo(t2);

            //set the count for number of results in the responsecomparison for term 1
            obj.setSearchTermOneResultCount(responseOne.getResponse().getMeta().getHits());
            //set the count for number of results in the responsecomparison for term 2
            obj.setSearchTermTwoResultCount(responseTwo.getResponse().getMeta().getHits());

            return obj;
    }

    public void insertNYTSummary(NYTOverview result) {

            nytMapper.insertSummary(result);
    }
}

