package fr.neo.revisions.mvc.controller;

import fr.neo.revisions.mvc.dao.MyObjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyObjectController {

    @Autowired
    private MyObjectDAO myObjectDAO;

    @GetMapping("/myObject")
    public String handleRequest(
            @RequestParam(name = "action", required = false, defaultValue = "liste") String action,
            @RequestParam(name = "n", required = false, defaultValue = "0") int n,
            Model model
    ) {
        if ("vignette".equals(action)) {
            // On récupère l'élément n-ième
            String obj = myObjectDAO.findById(n);
            model.addAttribute("object", obj);
            model.addAttribute("n", n);
            return "vignette"; // -> vignette.jsp
        } else {
            // On récupère la liste complète
            model.addAttribute("objects", myObjectDAO.findAll());
            return "liste";    // -> liste.jsp
        }
    }
}
