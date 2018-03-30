package mybatis.services;

import mybatis.mappers.rg.RGMapper;
import mybatis.model.rg.ChampionDto;
import mybatis.model.rg.StatsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RGService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RGMapper rgMapper;

    //------------------------------------------------------------
    // Pull character summary
    public ChampionDto searchCharacterbyID(String query, boolean persist) {
        String fQuery = "https://na1.api.riotgames.com/lol/static-data/v3/champions/" + query + "?&api_key=RGAPI-e9d550f4-a1c0-46f8-a1df-a8a8356893f1";

        ChampionDto response = restTemplate.getForObject(fQuery, ChampionDto.class);

        if (persist){
            insertCharacter(response);
        }
        return response;
    }

    //-------------------------------------------------------------
    // Insert Character to SQL Table character_summary
    public void insertCharacter(ChampionDto result) {
        rgMapper.insertSummary(result);
    }

    //-------------------------------------------------------------
    // Insert Character Stats to SQL Table character_stats
    public void insertStats(StatsDto stats){
        rgMapper.insertStats(stats);
    }

    //-------------------------------------------------------------
    // Pull character stats
    public StatsDto pullCharacterStatsbyID(String query, boolean persist) {
        String fQuery = "https://oc1.api.riotgames.com/lol/static-data/v3/champions/"+query+"?locale=en_US&champData=stats&api_key=YOURAPIKEY";

        System.out.println(fQuery);

        StatsDto response = restTemplate.getForObject(fQuery, StatsDto.class);
        response.setId(Integer.parseInt(query));

        if (persist){
            insertStats(response);
        }
        return response;
    }

    //GET
    public ChampionDto getById(int id){
        return rgMapper.getByID(id);
    }

    //CREATE
    public ChampionDto addNew(ChampionDto character) {
        rgMapper.insertSummary(character);
        return rgMapper.getByID(character.getId());
    }
    //UPDATE
    public ChampionDto updateById(ChampionDto character) {
        rgMapper.updateCharacter(character);
        return character;
    }

    //DELETE
    public ChampionDto deleteById(int id) {
        rgMapper.deleteCharacter(id);
        return rgMapper.getByID(id);
    }

}
