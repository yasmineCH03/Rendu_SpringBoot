package tn.esprit.championnat.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.championnat.entities.Pilote;
import tn.esprit.championnat.services.PiloteService;

@RestController
@AllArgsConstructor
@RequestMapping("/pilote")
public class PiloteRestController {

    PiloteService ps;


    @PostMapping ("/add_Pilote")
    public String addPilote (@RequestBody Pilote pilote)
    {
        return ps.addPilote(pilote);
    }
}
