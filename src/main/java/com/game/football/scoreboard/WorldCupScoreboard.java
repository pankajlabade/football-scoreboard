package com.game.football.scoreboard;

import com.game.football.model.Match;

import java.util.ArrayList;
import java.util.List;

public class WorldCupScoreboard implements Scoreboard {
    private List<Match> matches;

    public WorldCupScoreboard() {
        matches = new ArrayList<>();
    }

    /**
     * @param homeTeam
     * @param awayTeam
     */
    @Override
    public void startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
    }

    /**
     * @param homeTeam
     * @param awayTeam
     * @param homeScore
     * @param awayScore
     */
    @Override
    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {

    }

    /**
     * @param homeTeam
     * @param awayTeam
     */
    @Override
    public void finishMatch(String homeTeam, String awayTeam) {

    }

    /**
     * @return
     */
    @Override
    public int getMatchesCount() {
        return matches.size();
    }
}
