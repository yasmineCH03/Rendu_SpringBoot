package tn.esprit.championnat.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import tn.esprit.championnat.entities.Sponsor;
import tn.esprit.championnat.services.ISponsorService;
import tn.esprit.championnat.services.PiloteService;
import tn.esprit.championnat.services.SponsorService;

import java.util.List;


@Tag(name = "Gestion Sponsor", description = "API pour la gestion des sponsors du championnat")
@RestController
@AllArgsConstructor
@RequestMapping("/sponsor")
public class SponsorRestController {

    ISponsorService sp;

    @Operation(description = "Récupérer tous les sponsors")
    @GetMapping ("/all_sponsors")
    public List<Sponsor> getSponsors()
    {
        List<Sponsor> LSP = sp.listSponsors();
        return LSP;
    }

    @Operation(description = "Récupérer un sponsor par son ID")
    @GetMapping ("/one_sponsor/{sponsor_id}")
    public Sponsor getSponsor(@PathVariable("sponsor_id") Long sponsorId)
    {
        return sp.recupererSponsor(sponsorId);
    }

    @Operation(description = "Ajouter un nouveau sponsor (dateCreation auto, archived=false, bloquerContrat=false)")
    @PostMapping ("/Add_sponsor")
    public Sponsor addSponsor(@RequestBody Sponsor s)
    {
        return sp.ajouterSponsor(s);
    }

    @Operation(description = "Ajouter une liste de sponsors en une seule requête")
    @PostMapping ("Add_sponsors")
    public List<Sponsor> addSponsors(@RequestBody List<Sponsor> LSP)
    {
        return sp.ajouterSponsors(LSP);
    }

    @Operation(description = "Modifier un sponsor existant")
    @PutMapping ("update_Sponsor")
    public Sponsor updateSponsor(@RequestBody Sponsor s)
    {
        return sp.modifierSponsor(s);
    }

    @Operation(description = "Archiver un sponsor")
    @PutMapping ("/archiver_Sponsor/{sponsor_id}")
    public Boolean archiverSponsor(@PathVariable ("sponsor_id") Long sponsorID)
    {
        return sp.archiverSponsor(sponsorID);
    }
    @Operation(description = "Supprimer un sponsor")
    @DeleteMapping ("/delete_Sponsor/{sponsor_id}")
    public void deleteSponsor(@PathVariable ("sponsor_id") Long sponsorID)
    {
        sp.supprimerSponsor(sponsorID);
    }

}
