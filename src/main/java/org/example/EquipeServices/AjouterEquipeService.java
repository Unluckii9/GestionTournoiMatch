// Service pour ajouter une équipe
package org.example.EquipeServices;

import org.example.Events.EventManager;

import java.util.List;

public class AjouterEquipeService {
    private List<Equipe> equipes;
    private EventManager events;

    public AjouterEquipeService(List<Equipe> equipes, EventManager events) {
        this.equipes = equipes;
        this.events = events;
    }

    public void ajouterEquipe(String name, String members) {
        Equipe nouvelleEquipe = new Equipe(name, members);
        equipes.add(nouvelleEquipe);

        // Publication de l'événement de création d'équipe
        events.notify("nouvelleEquipe", nouvelleEquipe);
    }
}