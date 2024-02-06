package com.example.tennis_matches_api;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Match {
    private @Id @GeneratedValue Long id;
    private String side1;
    private String side2;
    private String score;
    private String winner;
    public Match() {}

    public Match(String side1, String side2, String score, String winner) {
        this.side1 = side1;
        this.side2 = side2;
        this.score = score;
        this.winner = winner;
    }

    public Long getId() {
        return this.id;
    }

    public String getSide1() {
        return this.side1;
    }

    public String getSide2() { return this.side2; }

    public String getScore() { return this.score; }

    public String getWinner() { return this.winner; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSide1(String side1) {
        this.side1 = side1;
    }

    public void setSide2(String side2) {
        this.side1 = side2;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
