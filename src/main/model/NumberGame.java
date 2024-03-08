package model;

import java.util.Random;
import java.lang.Math;

public class NumberGame extends Game {



    private int memNum;

    //EFFECTS: Initializes memNum=0, makes a game with level=0, highscore =0.
    public NumberGame() {
        super();

        memNum = 0;

    }


    //EFFECTS: Genereates a Random Number for the level
    public int getNumForLevel() {
        Random random = new Random();
        memNum =  random.nextInt(getMax()) + getMin();
        return memNum;

    }


    //EFFECTS: Returns upper bound for random number based on level
    private int getMax() {
        double max = Math.pow(10,super.getLevel());
        int intmax = (int)max;
        return intmax;
    }

    //EFFECTS: Returns lower bound for random number based on level
    private int getMin() {
        double min = Math.pow(10,super.getLevel() - 1);
        int intmin = (int)min;
        return intmin;
    }





}