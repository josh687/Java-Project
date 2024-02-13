package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.MemoryApp;

import static org.junit.jupiter.api.Assertions.*;

public class NumberGameTest {
    private NumberGame game;

    void runBefore() {
        game = new NumberGame();
    }

    @Test
    void testPlayGame() {
        System.out.println(game.getNumForLevel());
//        assertTrue(game.getNumForLevel() > 0 && game.getNumForLevel() < 100);
    }
}