// Service pour modifier les membres d'une équipe
package org.example.EquipeServices;

import org.example.Events.EventManager;

import java.util.List;

public class ModifierMembreEquipeService {
    private List<Equipe> equipes;
    private EventManager events;

    public ModifierMembreEquipeService(List<Equipe> equipes, EventManager events) {
        this.equipes = equipes;
        this.events = events;
    }

    public void modifierMembreEquipe(String nomEquipe, String nouveauMembre) {
        Equipe team = null;
        for (Equipe equipe : this.equipes) {
            team = equipe;
            if (team.getName().equals(nomEquipe)) {
                team.setMember(nouveauMembre);

                // Publier l'événement de modification d'équipe
                events.notify("modificationEquipe", team);

                return;
            }
        }
        team.setName(nomEquipe);
        events.notify("modificationEquipeErreur", team);
    }
}