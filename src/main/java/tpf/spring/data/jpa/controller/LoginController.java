package tpf.spring.data.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import tpf.spring.data.jpa.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"user","username"})
public class LoginController {

    @Autowired
    HttpServletRequest request;

//    @RequestMapping("/session/login")
    @RequestMapping(value="/session/login",method={RequestMethod.GET,RequestMethod.POST})
    public String login(User user, ModelMap map) {
        //user会自己注入session中
        //将username放入session作用域中，这样转发页面也可以取到这个数据。
//        map.addAttribute("username", user.getUserName());
        HttpSession httpSession = request.getSession();
        System.out.println(httpSession.getAttribute("username"));
        map.addAttribute("username", "12");
        /*if ( httpSession.getAttribute("username") == null ){
            return "redirect:/login.jsp";
        }*/
        return "/success";
    }

}
