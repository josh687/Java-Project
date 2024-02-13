package model;

import java.util.Random;
import java.lang.Math;

public class NumberGame extends Game {
    private int highscore;


    private int memNum;

    public NumberGame() {
        this.highscore = 0;

        memNum = 0;

    }

    public int getNumForLevel() {
        Random random = new Random();
        memNum =  random.nextInt(getMax()) + getMin();
        return memNum;

    }



    private int getMax() {
        double max = Math.pow(10,super.getLevel() + 1);
        int intmax = (int)max;
        return intmax;
    }

    private int getMin() {
        double min = Math.pow(10,super.getLevel());
        int intmin = (int)min;
        return intmin;
    }





}