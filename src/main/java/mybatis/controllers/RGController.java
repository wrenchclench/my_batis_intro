package mybatis.controllers;


import mybatis.model.rg.ChampionDto;
import mybatis.model.rg.StatsDto;
import mybatis.services.RGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// THIS WORKS: http://localhost:8080/lol/characterID?query=141&p=true

    @RestController
    @RequestMapping("/lol")
    public class RGController {

        @Autowired
        RGService rgService;

        @RequestMapping("/characterID")
        public ChampionDto searchRG(@RequestParam(value = "query", defaultValue = "id") String query,
                                    @RequestParam(value = "p", defaultValue = "true") boolean persist) {

            return rgService.searchCharacterbyID(query, persist);
        }

        @RequestMapping("/characterStats")
        public StatsDto searchRGStats(@RequestParam(value = "query", defaultValue = "id") String query,
                                      @RequestParam(value = "p", defaultValue = "true") boolean persist) {

            return rgService.pullCharacterStatsbyID(query, persist);

        }
        //GET
        @RequestMapping("/{id}")
        public ChampionDto getById(@PathVariable(value="id")int id) {
            return rgService.getById(id);
        }

        //POST
        @RequestMapping(method = RequestMethod.POST, value = "/")
        public ChampionDto addNew(@RequestBody ChampionDto character) {
            return rgService.addNew(character);
        }

        //PATCH
        @RequestMapping(method = RequestMethod.PATCH, value = "/")
        public ChampionDto updateById(@RequestBody ChampionDto character) {
            return rgService.updateById(character);
        }

        //DELETE
        @RequestMapping(method= RequestMethod.DELETE, value="/")
        public ChampionDto deleteById(@RequestParam(value="id")int id){
            return rgService.deleteById(id);
        }
    }

