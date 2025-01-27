package fr.neo.revisions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Ping {

    @GetMapping(path = "/api/public/ping", produces = {"text/plain"})
    public String ping() {
        return "Pong !";
    }

}
