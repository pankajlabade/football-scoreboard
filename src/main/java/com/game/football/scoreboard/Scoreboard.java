package com.game.football.scoreboard;

import com.game.football.model.Match;

public interface Scoreboard {
    void startMatch(String homeTeam, String awayTeam);

    void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore);

    void finishMatch(String homeTeam, String awayTeam);

    int getMatchesCount();

    Match getMatch(String homeTeam, String awayTeam);
}
