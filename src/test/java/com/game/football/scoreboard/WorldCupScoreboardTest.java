package com.game.football.scoreboard;

import com.game.football.model.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WorldCupScoreboardTest {
    private Scoreboard scoreboard;

    @BeforeEach
    public void setUp() {
        scoreboard = new WorldCupScoreboard();
    }

    @Test
    public void test_startMatch() {
        scoreboard.startMatch("Argentina", "Brazil");
        scoreboard.startMatch("Canada", "Denmark");

        assertEquals(2, scoreboard.getMatchesCount());
    }

    @Test
    public void test_updateScore() {
        scoreboard.startMatch("Argentina", "Brazil");
        scoreboard.updateScore("Argentina", "Brazil", 2, 1);

        Match match = scoreboard.getMatch("Argentina", "Brazil");
        assertEquals(2, match.getHomeScore());
        assertEquals(1, match.getAwayScore());
    }

    @Test
    public void test_finishMatch() {
        scoreboard.startMatch("Argentina", "Brazil");
        scoreboard.finishMatch("Argentina", "Brazil");

        assertNull(scoreboard.getMatch("Argentina", "Brazil"));
        assertEquals(0, scoreboard.getMatchesCount());
    }
    
  }
