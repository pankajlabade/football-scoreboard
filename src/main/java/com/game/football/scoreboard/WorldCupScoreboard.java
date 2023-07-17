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
        Match match = getMatch(homeTeam, awayTeam);
        if (null != match) {
            match.updateScore(homeScore, awayScore);
        }
    }

    /**
     * @param homeTeam
     * @param awayTeam
     */
    @Override
    public void finishMatch(String homeTeam, String awayTeam) {
        Match matchToRemove = getMatch(homeTeam, awayTeam);
        if (null != matchToRemove) {
            matchToRemove.finish();
            matches.remove(matchToRemove);
        }
    }

    /**
     * @return
     */
    @Override
    public int getMatchesCount() {
        return matches.size();
    }

    /**
     * @param homeTeam
     * @param awayTeam
     * @return
     */
    @Override
    public Match getMatch(String homeTeam, String awayTeam) {
        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                return match;
            }
        }
        return null;
    }
}
