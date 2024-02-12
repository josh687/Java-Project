package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.MemoryApp;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    void runBefore() {
        game = new Game();
    }

    @Test
    void testPlayGame() {
        System.out.println(game.getNumForLevel());

    }
}