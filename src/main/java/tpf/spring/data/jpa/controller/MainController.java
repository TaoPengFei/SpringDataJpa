package tpf.spring.data.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tpf.spring.data.jpa.service.PersonService;

@Controller
public class MainController {



    @Autowired
    private PersonService personService;

    @RequestMapping(value = "QQ", method = RequestMethod.POST)
    public String index(){
        return "success";
    }


    @RequestMapping(value = "savePerson", method = RequestMethod.POST)
    @ResponseBody
    public String savePerson(){
        personService.savePerson();
        return "success!";
    }
}
