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
        game.nextLevel();
        assertEquals(2, game.getLevel());
        assertTrue(game.getNumForLevel() > 100 && game.getNumForLevel() < 10000);

    }
}