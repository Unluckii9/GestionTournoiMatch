// Service pour modifier le nom d'une équipe
package org.example.EquipeServices;

import org.example.Events.EventManager;

import java.util.List;

public class ModifierNomEquipeService {
    private List<Equipe> equipes;
    private EventManager events;

    public ModifierNomEquipeService(List<Equipe> equipes, EventManager events) {
        this.equipes = equipes;
        this.events = events;
    }

    public void modifierNomEquipe(String ancienNom, String nouveauNom) {
        Equipe team = null;
        for (Equipe equipe : equipes) {
            team = equipe;
            if (team.getName().equals(ancienNom)) {
                team.setName(nouveauNom);

                // Publier l'événement de modification d'équipe
                events.notify("modificationEquipe", team);
                return;
            }
        }
        team.setName(ancienNom);
        events.notify("modificationEquipeErreur", team);
    }
}