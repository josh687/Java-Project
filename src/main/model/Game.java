package model;

import java.util.Random;
import java.lang.Math;

public class Game {
    private int highscore;

    private int level;
    private int memNum;





    public Game() {
        this.highscore = 0;

        level = 1;
        memNum = 0;

    }



    public int getHighScore() {
        return highscore;
    }

    public void resetGame() {
        newHighscore();
        level = 1;
    }

    public void newHighscore() {
        if (level > highscore) {
            highscore = level;
        }
    }

    public int getNumForLevel() {
        Random random = new Random();
        memNum =  random.nextInt(getMax()) + getMin();
        return memNum;

    }

    public void nextLevel() {
        level = level + 1;

    }

    public int getMax() {
        double max = Math.pow(10,level + 1);
        int intmax = (int)max;
        return intmax;
    }

    public int getMin() {
        double min = Math.pow(10,level);
        int intmin = (int)min;
        return intmin;
    }



}