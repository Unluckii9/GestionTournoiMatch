package org.example.EquipeServices;

public class Equipe {
    private String name;
    private String member;
    private int score;

    // Constructeur
    public Equipe(String name, String member) {
        this.name = name;
        this.member = member;
        this.score = 0; // Score initialisé à 0 lors de la création
    }

    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "name='" + name + '\'' +
                ", member=" + member +
                ", score=" + score +
                '}';
    }
}
