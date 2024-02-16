package model;

public class Game {
    private int highscore;
    private int level;

    public Game() {
        this.highscore = 0;
        level = 1;
    }

    public int getHighScore() {
        return highscore;
    }

    public void resetGame() {
        highscore = 0;
        level = 1;
    }

    //Increases Level by one
    public void nextLevel() {
        level = level + 1;

    }

    //modifies this
    //EFFECTS makes the highscore = to level if it is smaller than level
    public void newHighscore() {
        if (level > highscore) {
            highscore = level;
        }
    }

    public int getLevel() {
        return level;
    }
}
