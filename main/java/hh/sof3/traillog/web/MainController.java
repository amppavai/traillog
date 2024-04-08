package hh.sof3.traillog.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    //etusivu
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex() {
        return "index"; //index.html
    }

    //login
    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login() {
        return "/login";
    }
}
