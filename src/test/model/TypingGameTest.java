package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TypingGameTest {
    private TypingGame game;

    @BeforeEach
    void runBefore() {
        game = new TypingGame();

    }

    @Test
    public void GameTestForTyping() {
        assertEquals(1,game.getLevel());
        assertTrue(0 <= game.scentence.length() && 2 >= game.scentence.length());
        game.nextLevel();
        assertEquals(2,game.getLevel());
        assertTrue(0 <= game.scentence.length() && 3 >= game.scentence.length());
        game.newHighscore();
        assertEquals(2,game.getHighScore());
        game.resetGame();
        assertEquals(1,game.getLevel());
        assertEquals(0,game.getHighScore());
        assertEquals(1, (game.getScentence()).length());



    }
}