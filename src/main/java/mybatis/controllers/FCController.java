package mybatis.controllers;


import mybatis.model.fc.PersonSummary;
import mybatis.services.FCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fullcontact")
public class FCController {

        @Autowired
        FCService fcService;

        //Controller to pull FullContact data using only an email address
        @RequestMapping("/email")
        public PersonSummary searchByEmail(@RequestParam(value = "query", defaultValue = "email") String query,
                                           @RequestParam(value = "p", defaultValue = "true") boolean persist) {

            return fcService.searchByEmail(query, persist);
        }
}
