// Service pour obtenir des équipes
package org.example.EquipeServices;

import java.util.List;

public class ObtenirEquipeService {
    private List<Equipe> equipes;

    public ObtenirEquipeService(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public List<Equipe> getToutesLesEquipes() {
        return equipes;
    }

    public Equipe getEquipeParNom(String name) {
        for (Equipe equipe : equipes) {
            if (equipe.getName().equals(name)) {
                return equipe;
            }
        }
        return null;
    }
}