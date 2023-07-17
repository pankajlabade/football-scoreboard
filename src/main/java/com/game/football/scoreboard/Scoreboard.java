package com.game.football.scoreboard;
public interface Scoreboard {
    void startMatch(String homeTeam, String awayTeam);

    void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore);

    void finishMatch(String homeTeam, String awayTeam);

    int getMatchesCount();
}
