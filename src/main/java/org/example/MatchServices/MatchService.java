package org.example.MatchServices;

import org.example.EquipeServices.Equipe;
import org.example.Events.EventManager;

import java.util.Random;

public class MatchService {
    private EventManager events;

    public MatchService(EventManager events) {
        this.events = events;
    }

    public void organiserMatch(Equipe equipe1, Equipe equipe2, int scoreEquipe1, int scoreEquipe2) {
        Match match = new Match(equipe1, equipe2, scoreEquipe1, scoreEquipe2);

        Random rand = new Random();
        int randomNum = rand.nextInt(10) + 1;

        if (randomNum == 1) {
            // Match annulé
            match.setScoreEquipe1(0);
            match.setScoreEquipe2(0);
            events.notify("matchAnnule", match);
            return;
        }

        if (scoreEquipe1 > scoreEquipe2) {
            equipe1.setScore(equipe1.getScore() + 3);
            equipe2.setScore(equipe2.getScore());
        } else if (scoreEquipe1 == scoreEquipe2) {
            equipe1.setScore(equipe1.getScore() + 1);
            equipe2.setScore(equipe2.getScore() + 1);
        } else {
            equipe2.setScore(equipe2.getScore() + 3);
            equipe1.setScore(equipe1.getScore());
        }

        int scoreTotal = scoreEquipe1 + scoreEquipe2;
        int totalEquipe1 = scoreEquipe1;
        int totalEquipe2 = scoreEquipe2;
        int pointEquipe1 = 0;
        int pointEquipe2 = 0;
        for (int i = 0; i < scoreTotal; i++) {
            Random random = new Random();
            int equipeChoisie = random.nextInt(2) + 1; // 1 ou 2

            if ((equipeChoisie == 1 && totalEquipe1 > 0) || totalEquipe2 == 0) {
                pointEquipe1++;
                totalEquipe1--;
                System.out.println("Point pris par : " + equipe1.getName() + " - (" + pointEquipe1 + " - " + pointEquipe2 + ")");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else if (totalEquipe2 > 0) {
                pointEquipe2++;
                totalEquipe2--;
                System.out.println("Point pris par : " + equipe2.getName() + " - (" + pointEquipe1 + " - " + pointEquipe2 + ")");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        events.notify("matchTermine", match);

    }
}
