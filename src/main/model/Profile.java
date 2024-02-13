package model;


import java.util.ArrayList;

public class Profile {
    private ArrayList<NumberGame> numGames;
    private int numHighScore;
    private String name;


    public Profile(String name) {
        this.name = name;
        numHighScore = 0;
        numGames = new ArrayList();
    }

    public void addGame(NumberGame game) {
        numGames.add(game);
    }

}
