package com.game.football.scoreboard;

import com.game.football.model.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void getMatch_shouldReturnMatchIfExists() {
        scoreboard.startMatch("Argentina", "Brazil");

        Match match = scoreboard.getMatch("Argentina", "Brazil");

        assertEquals("Argentina", match.getHomeTeam());
        assertEquals("Brazil", match.getAwayTeam());
    }

    @Test
    public void getMatch_shouldReturnNullIfMatchDoesNotExist() {
        Match match = scoreboard.getMatch("Argentina", "Brazil");

        assertNull(match);
    }

    @Test
    public void getMatchesCount_shouldReturnCorrectCount() {
        scoreboard.startMatch("Argentina", "Brazil");
        scoreboard.startMatch("Canada", "Denmark");
        scoreboard.startMatch("England", "France");

        assertEquals(3, scoreboard.getMatchesCount());
    }
    @Test
    public void isMatchInProgress_shouldReturnTrueIfMatchIsInProgress() {
        scoreboard.startMatch("Argentina", "Brazil");

        assertTrue(scoreboard.isMatchInProgress("Argentina", "Brazil"));
    }

    @Test
    public void isMatchInProgress_shouldReturnFalseIfMatchIsFinished() {
        scoreboard.startMatch("Argentina", "Brazil");
        scoreboard.finishMatch("Argentina", "Brazil");

        assertFalse(scoreboard.isMatchInProgress("Argentina", "Brazil"));
    }

    @Test
    public void isMatchInProgress_shouldReturnFalseIfMatchDoesNotExist() {
        assertFalse(scoreboard.isMatchInProgress("Argentina", "Brazil"));
    }

    @Test
    public void isMatchInProgress_shouldReturnFalseIfNoMatchesExist() {
        assertFalse(scoreboard.isMatchInProgress("Argentina", "Brazil"));
    }

    @Test
    public void isMatchInProgress_shouldReturnFalseIfHomeTeamDoesNotExist() {
        scoreboard.startMatch("Argentina", "Brazil");

        assertFalse(scoreboard.isMatchInProgress("Team X", "Brazil"));
    }

    @Test
    public void isMatchInProgress_shouldReturnFalseIfAwayTeamDoesNotExist() {
        scoreboard.startMatch("Argentina", "Brazil");

        assertFalse(scoreboard.isMatchInProgress("Argentina", "Team X"));
    }

    @Test
    public void isMatchInProgress_shouldReturnFalseIfHomeTeamAndAwayTeamDoNotExist() {
        assertFalse(scoreboard.isMatchInProgress("Team X", "Team Y"));
    }
    
  }
