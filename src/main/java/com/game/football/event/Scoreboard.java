package com.game.football.event;

import com.game.football.model.Match;

import java.util.List;

/**
 * Interface for match scoreboard
 */
public interface Scoreboard {

    void startMatch(String homeTeam, String awayTeam);

    void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore);

    void finishMatch(String homeTeam, String awayTeam);

    int getMatchesCount();

    Match getMatch(String homeTeam, String awayTeam);

    boolean isMatchInProgress(String teamX, String teamY);

    List<Match> getMatchesSummary();
}
