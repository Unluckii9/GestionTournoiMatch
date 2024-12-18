package org.example.Events;

import org.example.EquipeServices.Equipe;
import org.example.MatchServices.Match;

public class NotificationListener implements EventListener {
    @Override
    public void onEvent(String eventType, Object data) {
        if ("nouvelleEquipe".equals(eventType)) {
            Equipe equipe = (Equipe) data;
            System.out.println("\n Notification : Nouvelle équipe créée - " + equipe.getName() + " - " + equipe.getMember());
        } else if ("matchTermine".equals(eventType)) {
            Match match = (Match) data;
            System.out.println("\n Notification : Match terminé - " + match.toString());
        } else if ("modificationEquipe".equals(eventType)) {
            Equipe equipe = (Equipe) data;
            System.out.println("\n Notification : Équipe modifiée - " + equipe.getName() + " - " + equipe.getMember());
        } else if ("suppressionEquipe".equals(eventType)) {
            Equipe equipe = (Equipe) data;
            System.out.println("\n Notification : Équipe supprimée - " + equipe.getName());
        } else if ("modificationEquipeErreur".equals(eventType)) {
            System.out.println("\n Notification : Échec de la modification - Nom d'équipe introuvable.");
        } else if ("suppressionEquipeErreur".equals(eventType)) {
            System.out.println("\n Notification : Échec de la suppression - Nom d'équipe introuvable.");
        } else if ("matchAnnule".equals(eventType)) {
            Match match = (Match) data;
            System.out.println("\n Notification : Match annulé - " + match.toString());
        }
    }
}
