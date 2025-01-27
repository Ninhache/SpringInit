package fr.neo.revisions;

import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class TemplateController {

    @Autowired
    JdbcUserDetailsManager mesutilisateurs;

    @RequestMapping("/")
    @ResponseBody
    public String test() {
        return "All is ok !";
    }

    @RequestMapping("/public")
    public String v1(Model model) {
        return "public/v1";
    }

    @RequestMapping("/public/v3")
    public String v3(Model model) {
        return "public/v3";
    }

    @RequestMapping("/private")
    public String v2(Model model, Principal principal) {
        return "private/v2";
    }

    @GetMapping("/principal")
    @ResponseBody
    public Object principal(Principal principal) {
        return principal;
    }

    @Autowired
    JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/creer")
    @ResponseBody
    public Object creerUser(@RequestParam String login, @RequestParam String password) {
        UserDetails user = User
                .withUsername(login)
                .password(encoder.encode(password))
                .roles("USER")
                .build();

        jdbcUserDetailsManager.createUser(user);
        return user;
    }

}