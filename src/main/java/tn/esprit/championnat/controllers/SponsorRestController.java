package tn.esprit.championnat.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import tn.esprit.championnat.entities.Sponsor;
import tn.esprit.championnat.services.ISponsorService;
import tn.esprit.championnat.services.PiloteService;
import tn.esprit.championnat.services.SponsorService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sponsor")
public class SponsorRestController {

    ISponsorService sp;

    @GetMapping ("/all_sponsors")
    public List<Sponsor> getSponsors()
    {
        List<Sponsor> LSP = sp.listSponsors();
        return LSP;
    }

    @GetMapping ("/one_sponsor/{sponsor_id}")
    public Sponsor getSponsor(@PathVariable("sponsor_id") Long sponsorId)
    {
        return sp.recupererSponsor(sponsorId);
    }

    @PostMapping ("/Add_sponsor")
    public Sponsor addSponsor(@RequestBody Sponsor s)
    {
        return sp.ajouterSponsor(s);
    }

    @PostMapping ("Add_sponsors")
    public List<Sponsor> addSponsors(@RequestBody List<Sponsor> LSP)
    {
        return sp.ajouterSponsors(LSP);
    }

    @PutMapping ("update_Sponsor")
    public Sponsor updateSponsor(@RequestBody Sponsor s)
    {
        return sp.modifierSponsor(s);
    }

    @DeleteMapping ("/delete_Sponsor/{sponsor_id}")
    public void deleteSponsor(@PathVariable ("sponsor_id") Long sponsorID)
    {
        sp.supprimerSponsor(sponsorID);
    }

}
