package ai.bionic.birder.webpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
    @RequestMapping(value = "/")
    public String home() {
       return "index";
    }     
}