package com.game.football.scoreboard;

import com.game.football.model.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * WorldCupScoreboard implements the functionality of Start a new match, Update score,
 * Finish match currently in progress, Get a summary of matches in progress
 */
public class WorldCupScoreboard implements Scoreboard {
    private List<Match> matches;

    public WorldCupScoreboard() {
        matches = new ArrayList<>();
    }

    /**
     * Start a new match
     * @param homeTeam Home Team
     * @param awayTeam Away Team
     */
    @Override
    public void startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
    }

    /**
     * Update the score of in progress match
     * @param homeTeam Home Team
     * @param awayTeam Away Team
     * @param homeScore Home Team Score
     * @param awayScore Away Team Score
     */
    @Override
    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Match match = getMatch(homeTeam, awayTeam);
        if (null != match) {
            match.updateScore(homeScore, awayScore);
        }
    }

    /**
     * Finish the match
     * @param homeTeam Home Team
     * @param awayTeam Away Team
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
     * Get total in progress matches
     * @return total number of in progress matches
     */
    @Override
    public int getMatchesCount() {
        return matches.size();
    }

    /**
     * Get a match from list of matches
     * @param homeTeam Home Team
     * @param awayTeam Away Team
     * @return Match
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

    /**
     * Check if match is in progress
     * @param homeTeam Home Team
     * @param awayTeam Away Team
     * @return boolean match in progress
     */
    @Override
    public boolean isMatchInProgress(String homeTeam, String awayTeam) {
        Match match = getMatch(homeTeam, awayTeam);
        return null != match && !match.isFinished();
    }

    /**
     * Get summary of in progress matches
     * @return List<Match>
     */
    @Override
    public List<Match> getMatchesSummary() {
        List<Match> summary = matches.stream()
                .filter(match -> !match.isFinished())
                .collect(Collectors.toList());

        summary.sort(Comparator.comparingInt(Match::getTotalScore)
                .reversed()
                .thenComparing(Match::getStartTime)
                .reversed());

        // Reverse the summary list to get the correct ordering
        List<Match> reversedSummary = new ArrayList<>(summary);
        Collections.reverse(reversedSummary);

        return reversedSummary;
    }
}
