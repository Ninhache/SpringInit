package fr.neo.revisions.mvc.controller;

import fr.neo.revisions.mvc.dao.PartieRepository;
import fr.neo.revisions.mvc.model.Partie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/partie")
public class PartieController {

    @Autowired
    private PartieRepository partieRepository;

    // Liste de toutes les parties
    @GetMapping
    public String handlePartie(
            @RequestParam(name="action", required=false, defaultValue="list") String action,
            @RequestParam(name="id", required=false) Long id,
            Model model
    ) {
        switch (action) {
            case "voir":
                if (id != null) {
                    Partie p = partieRepository.findById(id).orElse(null);
                    model.addAttribute("partie", p);
                }
                return "view";  // view.jsp
            case "modifier":
                if (id != null) {
                    Partie p = partieRepository.findById(id).orElse(null);
                    model.addAttribute("partie", p);
                } else {
                    model.addAttribute("partie", new Partie());
                }
                // Ici on pourrait charger la liste des joueurs pour la combobox
                // model.addAttribute("joueurs", joueurRepository.findAll());
                return "edit";   // edit.jsp
            case "delete":
                if (id != null) {
                    partieRepository.deleteById(id);
                }
                return "redirect:/partie?action=list";
            case "list":
            default:
                List<Partie> allParties = partieRepository.findAll();
                model.addAttribute("parties", allParties);
                return "listParties";  // listParties.jsp
        }
    }

    // Méthode POST pour sauvegarder la partie (suite au formulaire edit.jsp)
    @PostMapping("/save")
    public String savePartie(@ModelAttribute Partie partie) {
        // On peut imaginer faire des vérifications ici
        partieRepository.save(partie);
        return "redirect:/partie?action=list";
    }
}
