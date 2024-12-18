package org.example;

import org.example.EquipeServices.*;
import org.example.Events.EventManager;
import org.example.Events.NotificationListener;
import org.example.MatchServices.MatchService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Créer le gestionnaire d'événements
        EventManager eventManager = new EventManager();

        NotificationListener notificationListener = new NotificationListener();
        eventManager.subscribe("nouvelleEquipe", notificationListener);
        eventManager.subscribe("modificationEquipe", notificationListener);
        eventManager.subscribe("suppressionEquipe", notificationListener);
        eventManager.subscribe("modificationEquipeErreur", notificationListener);
        eventManager.subscribe("suppressionEquipeErreur", notificationListener);
        eventManager.subscribe("matchTermine", notificationListener);
        eventManager.subscribe("matchAnnule", notificationListener);

        List<Equipe> equipes = new ArrayList<>();

        AjouterEquipeService ajouterEquipeService = new AjouterEquipeService(equipes, eventManager);
        SupprimerEquipeService supprimerEquipeService = new SupprimerEquipeService(equipes, eventManager);
        ModifierNomEquipeService modifierNomEquipeService = new ModifierNomEquipeService(equipes, eventManager);
        ModifierMembreEquipeService modifierMembreEquipeService = new ModifierMembreEquipeService(equipes, eventManager);
        ObtenirEquipeService obtenirEquipeService = new ObtenirEquipeService(equipes);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Menu de sélection d'options
            System.out.println("\n=== Gestion des équipes ===");
            System.out.println("1. Gérer les équipes");
            System.out.println("2. Organiser un match");
            System.out.println("3. Afficher le classement");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");

            // Lire le choix de l'utilisateur
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    // Sous-menu de gestion des équipes
                    System.out.println("\n=== Sous-menu de gestion des équipes ===");
                    System.out.println("1. Ajouter une équipe");
                    System.out.println("2. Modifier une équipe");
                    System.out.println("3. Supprimer une équipe");
                    System.out.print("Choisissez une option : ");

                    int gererEquipe = scanner.nextInt();
                    scanner.nextLine(); // Consommer le retour à la ligne

                    switch (gererEquipe) {
                        case 1:
                            // Ajouter une équipe
                            System.out.print("Nom de l'équipe à ajouter : ");
                            String nomEquipe = scanner.nextLine();
                            System.out.print("Membres de l'équipe (séparés par des virgules) : ");
                            String membres = scanner.nextLine();
                            ajouterEquipeService.ajouterEquipe(nomEquipe, membres);
                            break;

                        case 2:
                            // Modifier une équipe
                            System.out.println("\n=== Sous-menu de modification de l'équipe ===");
                            System.out.println("1. Modifier le nom de l'équipe");
                            System.out.println("2. Modifier les membres de l'équipe");
                            System.out.print("Choisissez une option : ");

                            int modificationEquipe = scanner.nextInt();
                            scanner.nextLine(); // Consommer le retour à la ligne

                            switch (modificationEquipe) {
                                case 1:
                                    // Modifier le nom de l'équipe
                                    System.out.print("Nom de l'équipe à modifier : ");
                                    String ancienNom = scanner.nextLine();
                                    System.out.print("Nouveau nom de l'équipe : ");
                                    String nouveauNom = scanner.nextLine();
                                    modifierNomEquipeService.modifierNomEquipe(ancienNom, nouveauNom);
                                    break;

                                case 2:
                                    // Modifier les membres de l'équipe
                                    System.out.print("Nom de l'équipe à modifier : ");
                                    String nomEquipeAModifier = scanner.nextLine();
                                    System.out.print("Nouveaux membres de l'équipe (séparés par des virgules) : ");
                                    String nouveauxMembres = scanner.nextLine();
                                    modifierMembreEquipeService.modifierMembreEquipe(nomEquipeAModifier, nouveauxMembres);
                                    break;

                                default:
                                    System.out.println("Option invalide. Essayez encore.");
                            }
                            break;

                        case 3:
                            // Supprimer une équipe
                            System.out.print("Nom de l'équipe à supprimer : ");
                            String nomASupprimer = scanner.nextLine();
                            supprimerEquipeService.supprimerEquipe(nomASupprimer);
                            break;

                        default:
                            System.out.println("Option invalide. Essayez encore.");
                    }
                    break;

                case 2:
                    // Organiser un match
                    System.out.print("Nom de la première équipe : ");
                    String nomEquipe1 = scanner.nextLine();
                    System.out.print("Nom de la deuxième équipe : ");
                    String nomEquipe2 = scanner.nextLine();

                    Equipe equipe1 = obtenirEquipeService.getEquipeParNom(nomEquipe1);
                    Equipe equipe2 = obtenirEquipeService.getEquipeParNom(nomEquipe2);

                    if (equipe1 != null && equipe2 != null) {
                        System.out.print("Score de " + equipe1.getName() + ": ");
                        int scoreEquipe1 = scanner.nextInt();
                        System.out.print("Score de " + equipe2.getName() + ": ");
                        int scoreEquipe2 = scanner.nextInt();
                        scanner.nextLine(); // Consommer le retour à la ligne

                        MatchService matchService = new MatchService(eventManager);
                        matchService.organiserMatch(equipe1, equipe2, scoreEquipe1, scoreEquipe2);
                    } else {
                        System.out.println("Une ou les deux équipes n'existent pas.");
                    }
                    break;

                case 3:
                    // Afficher le classement
                    System.out.println("\n=== Classement des équipes ===");
                    List<Equipe> equipesClassement = obtenirEquipeService.getToutesLesEquipes();
                    for (Equipe equipe : equipesClassement) {
                        System.out.println(equipe.getName() + " - Score: " + equipe.getScore());
                    }
                    break;

                case 4:
                    // Quitter le programme
                    System.out.println("Au revoir !");
                    return;

                default:
                    // Si l'option est invalide
                    System.out.println("Option invalide. Essayez encore.");
            }
        }
    }
}
