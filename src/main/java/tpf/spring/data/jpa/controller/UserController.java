package tpf.spring.data.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tpf.spring.data.jpa.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "saveUser", method = RequestMethod.GET)
    @ResponseBody
    public String saveUsers(){
        userService.saveUser();

        return "User 添加成功!";
    }

}
