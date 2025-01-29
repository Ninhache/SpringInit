package fr.neo.revisions.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chess")
public class ChessController {

    // On imagine qu'on a un service/DAO pour manipuler les parties d'échecs
    // @Autowired
    // private ChessService chessService;

    @GetMapping
    public String defaultAction() {
        // Par défaut, renvoie vers l'affichage du plateau ?
        return "redirect:/chess?action=afficherPlateau";
    }

    @GetMapping(params = "action")
    public String handleChessActions(
            @RequestParam("action") String action,
            @RequestParam(name="idPartie", required=false) Long idPartie,
            @RequestParam(name="origine", required=false) String origine,
            @RequestParam(name="destination", required=false) String destination,
            Model model
    ) {
        switch (action) {
            case "creerPartie":
                // chessService.creerPartie(...) renvoie par ex un id de partie
                // Long newId = chessService.creerPartie();
                // model.addAttribute("idPartie", newId);
                // On redirige ensuite vers afficherPlateau
                return "redirect:/chess?action=afficherPlateau&idPartie=42"; // ex
            case "afficherPlateau":
                // Charger la partie en BDD/fichier
                // model.addAttribute("plateau", service.getPlateau(idPartie));
                // model.addAttribute("monTour", service.isCestMonTour(idPartie, monIdJoueur));
                return "plateau"; // plateau.jsp
            case "afficheDestination":
                // Si c'est à moi de jouer, je calcule les destinations possibles pour la pièce
                // model.addAttribute("plateau", ...)
                // model.addAttribute("origineChoisie", origine)
                // model.addAttribute("destinationsPossibles", service.getDestinations(origine))
                return "plateau";
            case "jouer":
                // Vérifie si c'est à moi de jouer
                // si oui => chessService.jouer(idPartie, origine, destination)
                // Vérifie si la partie est terminée
                // Mettre à jour la base si besoin
                return "plateau";
            default:
                return "plateau";
        }
    }
}
