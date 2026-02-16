package tn.esprit.championnat.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.championnat.entities.Equipe;
import tn.esprit.championnat.services.EquipeService;

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {

    EquipeService es;

    @PostMapping ("/add_equipe")
    public Equipe addEquipe(@RequestBody Equipe e)
    {
        return es.ajouterEquipe(e);
    }
}
