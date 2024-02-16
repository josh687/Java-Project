package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {
    private Profile profile;
    private TypingGame type;
    private NumberGame num;

    @BeforeEach
    void runBefore() {
        profile = new Profile("josh");
        type = new TypingGame();
        num = new NumberGame();

    }

    @Test
    public void profileTest() {
        profile.newHighScoreType(3);
        profile.newHighScoreNum(3);
        assertEquals(3,profile.getHighScore());
        assertEquals(3,profile.getTypeHighScore());
        profile.newHighScoreType(2);
        profile.newHighScoreNum(2);
        assertEquals(3,profile.getHighScore());
        assertEquals(3,profile.getTypeHighScore());
        assertEquals("josh",profile.getName());
        profile.addTypeGame(type);
        profile.addNumGame(num);
        assertEquals(1,profile.getNumGames().size());
        assertEquals(1,profile.getTypeGames().size());
    }



}
