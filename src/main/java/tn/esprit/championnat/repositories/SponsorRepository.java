package tn.esprit.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.championnat.entities.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor,Long>
{

}
