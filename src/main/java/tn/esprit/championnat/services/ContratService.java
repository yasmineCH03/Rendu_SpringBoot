package tn.esprit.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

public class ContratService implements IContratSservice{


    @Override
    @Scheduled(cron = "*/30 * * * * *")
    public void archiverContrats() {

    }
}
