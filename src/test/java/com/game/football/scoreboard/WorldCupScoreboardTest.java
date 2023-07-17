package com.game.football.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldCupScoreboardTest {
    private Scoreboard scoreboard;

    @BeforeEach
    public void setUp() {
        scoreboard = new WorldCupScoreboard();
    }

    @Test
    public void test_startMatch() {
        scoreboard.startMatch("Team A", "Team B");
        scoreboard.startMatch("Team C", "Team D");

        assertEquals(2, scoreboard.getMatchesCount());
    }
  }
