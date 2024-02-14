package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.NumberGame;
import static org.junit.jupiter.api.Assertions.*;

public class NumberGameTest {
    private Game game;

    @BeforeEach
    void runBefore() {
        game = new NumberGame();

    }

    @Test
    void testPlayGame() {
        assertEquals(1, game.getLevel());
        game.nextLevel();
        assertEquals(2, game.getLevel());

    }
}