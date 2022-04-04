package com.leaderboard.gameSocialMedia.games.guessingGame;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@NamedNativeQuery(
        name  = "GuessingGameScoreBoard.findTop",
        query =  "select * from guessing_game_score_board ORDER BY score ASC LIMIT 15",
        resultClass = GuessingGameScoreBoard.class
)
public class GuessingGameScoreBoard {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private int score;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}