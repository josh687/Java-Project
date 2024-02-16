package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberGameTest {
    private NumberGame game;

    @BeforeEach
    void runBefore() {
        game = new NumberGame();

    }

    @Test
    void testPlayGame() {
        assertEquals(1, game.getLevel());
        assertEquals(0,game.getHighScore());
        game.nextLevel();
        assertEquals(2, game.getLevel());
        assertTrue(game.getNumForLevel() > 10 && game.getNumForLevel() < 100);
        game.newHighscore();
        assertEquals(2,game.getHighScore());
        game.resetGame();
        assertEquals(1, game.getLevel());
        assertTrue(game.getNumForLevel() > 1 && game.getNumForLevel() < 10);
        game.nextLevel();
        game.nextLevel();
        game.nextLevel();
        game.newHighscore();
        assertEquals(4,game.getHighScore());
        game.resetLevel();
        game.newHighscore();
        assertEquals(4,game.getHighScore());


    }
}