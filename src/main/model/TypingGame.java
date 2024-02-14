package model;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class TypingGame extends Game {
    String scentence;

    public TypingGame() {
        super();
        scentence = "";

    }

    public String getScentence() {
        scentence = "";
        ArrayList<String> letters = new ArrayList<String>();
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");
        letters.add("e");
        letters.add("f");
        letters.add("g");
        letters.add("h");
        letters.add("i");
        letters.add("j");
        letters.add("k");
        letters.add("l");
        letters.add("m");
        letters.add("n");
        letters.add("o");
        letters.add("p");
        letters.add("q");
        letters.add("r");
        letters.add("s");
        letters.add("t");
        letters.add("u");
        letters.add("v");
        letters.add("w");
        letters.add("x");
        letters.add("y");
        letters.add("z");
        letters.add("#");


        for (int c = 1; c < super.getLevel() + 1; c++) {
            Random r = new Random();
            int low = 2;
            int high = 26;
            int result = r.nextInt(high - low) + low;
            scentence = scentence + letters.get(result);

        }
        return scentence;


    }


}