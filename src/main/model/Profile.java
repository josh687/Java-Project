package model;


import java.util.ArrayList;

public class Profile {
    private ArrayList<NumberGame> numGames;
    private ArrayList<TypingGame> typeGames;
    private int numHighScore;
    private int typeHighScore;
    private String name;


    public Profile(String name) {
        this.name = name;
        numHighScore = 0;
        typeHighScore = 0;
        typeGames = new ArrayList<>();

        numGames = new ArrayList();
    }

    public void addNumGame(NumberGame game) {
        numGames.add(game);
    }

    public void addTypeGame(TypingGame game) {
        typeGames.add(game);
    }

    public void newHighScoreNum(int val) {

        if (val > numHighScore) {
            numHighScore = val;

        }
    }




    public void newHighScoreType(int val) {

        if (val > typeHighScore) {
            typeHighScore = val;
        }
    }

    public int getHighScore() {
        return numHighScore;
    }


    public int getTypeHighScore() {
        return typeHighScore;
    }



    public String getName() {
        return name;
    }


}
