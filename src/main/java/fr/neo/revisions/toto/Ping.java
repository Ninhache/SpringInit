package fr.neo.revisions.toto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {

    @GetMapping(path = "/api/public/ping", produces = {"text/plain"})
    public String ping() {
        return "Pong !";
    }

}
