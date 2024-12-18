// Service pour supprimer une équipe
package org.example.EquipeServices;

import org.example.Events.EventManager;

import java.util.List;

public class SupprimerEquipeService {
    private List<Equipe> equipes;
    private EventManager events;

    public SupprimerEquipeService(List<Equipe> equipes, EventManager events) {
        this.equipes = equipes;
        this.events = events;
    }

    public void supprimerEquipe(String name) {
        Equipe team = null;
        for (Equipe equipe : equipes) {
            team = equipe;
            if (team.getName().equals(name)) {
                equipes.remove(equipe);

                // Publier l'événement de suppression d'équipe
                events.notify("suppressionEquipe", team);

                return;
            }
        }
        team.setName(name);
        events.notify("suppressionEquipeErreur", team);
    }
}
