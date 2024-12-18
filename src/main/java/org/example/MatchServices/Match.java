package org.example.MatchServices;

import org.example.EquipeServices.Equipe;

public class Match {
    private Equipe equipe1;
    private Equipe equipe2;
    private int scoreEquipe1;
    private int scoreEquipe2;

    public Match(Equipe equipe1, Equipe equipe2, int scoreEquipe1, int scoreEquipe2) {
        this.equipe1 = equipe1;
        this.equipe2 = equipe2;
        this.scoreEquipe1 = scoreEquipe1;
        this.scoreEquipe2 = scoreEquipe2;
    }

    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public int getScoreEquipe1() {
        return scoreEquipe1;
    }

    public void setScoreEquipe1(int scoreEquipe1) {
        this.scoreEquipe1 = scoreEquipe1;
    }

    public int getScoreEquipe2() {
        return scoreEquipe2;
    }

    public void setScoreEquipe2(int scoreEquipe2) {
        this.scoreEquipe2 = scoreEquipe2;
    }

    @Override
    public String toString() {
        return "Match{" +
                "equipe1=" + equipe1 +
                ", equipe2=" + equipe2 +
                ", scoreEquipe1=" + scoreEquipe1 +
                ", scoreEquipe2=" + scoreEquipe2 +
                '}';
    }
}
