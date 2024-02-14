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

    public void nextLevel() {
        level = level + 1;

    }


    public void newHighscore() {
        if (level > highscore) {
            highscore = level;
        }
    }

    public int getLevel() {
        return level;
    }
}
