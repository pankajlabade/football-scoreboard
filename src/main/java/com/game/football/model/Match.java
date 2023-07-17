package com.game.football.model;

import java.util.Date;

public class Match {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private Date startTime;
    private boolean finished;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.startTime = new Date();
        this.homeScore = 0;
        this.awayScore = 0;
        this.finished = false;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void updateScore(int homeScore, int awayScore) {
        if (!finished) {
            this.homeScore = homeScore;
            this.awayScore = awayScore;
        } else {
            throw new IllegalStateException("Cannot update score for a finished match.");
        }
    }

    public void finish() {
        finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }
}
