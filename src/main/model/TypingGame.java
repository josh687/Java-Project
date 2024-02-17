package model;


import java.util.Arrays;
import java.util.Random;
import java.util.List;


public class TypingGame extends Game {
    String scentence;

    public TypingGame() {
        super();
        scentence = "";

    }
    //MODIFIES :This
    // EFFECTS :Generates a string with string length = level
    public String getScentence() {
        scentence = "";
        List<String> letters = Arrays.asList("q", "w", "e", "r", "t", "y", "y", "u", "i", "p", "o",
                "a", "s", "d", "f", "g", "h", "j", "k", "l","z","x","c","v","b","n","m");


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