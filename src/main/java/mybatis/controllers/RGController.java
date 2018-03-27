package mybatis.controllers;

import mybatis.model.RiotGames.RGRoot;
import mybatis.services.RiotGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// THIS WORKS: http://localhost:8080/lol/characterID?query=141&p=true

    @RestController
    @RequestMapping("/lol")
    public class RGController {

        @Autowired
        RiotGamesService riotGamesService;

        @RequestMapping("/characterID")
        public RGRoot searchRG(@RequestParam(value = "query", defaultValue = "id") String query,
                               @RequestParam(value ="p", defaultValue = "true") boolean persist) {

            return riotGamesService.searchCharacterbyID(query,persist);
        }

}
