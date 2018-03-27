package mybatis.services;

import mybatis.mappers.riotGames.RGMapper;
import mybatis.model.RiotGames.RGRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotGamesService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RGMapper rgMapper;

    public RGRoot searchCharacterbyID(String query, boolean persist) {
        String fQuery = "https://na1.api.riotgames.com/lol/static-data/v3/champions/" + query + "?api_key=";

        RGRoot response = restTemplate.getForObject(fQuery, RGRoot.class);

        return response;

    }

    public void insertCharacter(RGRoot result) {

        rgMapper.insertSummary(result);

    }
}
