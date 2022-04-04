package com.leaderboard.gameSocialMedia.games.guessingGame;

import org.springframework.data.repository.CrudRepository;




public interface GuessingGameSBRepository extends CrudRepository<GuessingGameScoreBoard, Integer> {

    // Iterable<GuessingGameScoreBoard> findTop();
    //    top 15 rn
    Iterable<GuessingGameScoreBoard> findTop();

}