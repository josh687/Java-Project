package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class Profile implements Writable {
    private ArrayList<NumberGame> numGames;
    private ArrayList<TypingGame> typeGames;
    private int numHighScore;
    private int typeHighScore;
    private String name;



    //EFFECTS: Makes profile with 0 highscores, and empty games lists
    public Profile(String name) {
        this.name = name;
        numHighScore = 0;
        typeHighScore = 0;
        typeGames = new ArrayList<>();

        numGames = new ArrayList();
    }

    //MODIFIES:THIS
    //EFFECTS; adds typing game to list of profiles Number games
    public void addNumGame(NumberGame game) {
        numGames.add(game);
    }

    //MODIFIES:THIS
    //EFFECTS; adds typing game to list of profiles typing games
    public void addTypeGame(TypingGame game) {
        typeGames.add(game);
    }

    //MODIFIES: This
    //EFFECTS: changes the highscore of Number game if the val is higher than the current one
    public void newHighScoreNum(int val) {
        if (val > numHighScore) {
            numHighScore = val;
        }
    }

    //MODIFIES: This
    //EFFECTS: changes the highscore of typing game if the val is higher than the current one
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

    public ArrayList<TypingGame> getTypeGames() {
        return typeGames;
    }

    public ArrayList<NumberGame> getNumGames() {
        return numGames;
    }

    public String getName() {
        return name;
    }


    //EFFECTS: sets highscore
    public void setNumHighScore(int i) {
        numHighScore = i;
    }

    //EFFECTS: sets highscore
    public void setTypeHighScore(int i) {
        typeHighScore = i;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("number HighScore", numHighScore);
        json.put("Typer Highscore", typeHighScore);
        json.put("numbergames", numberGamesToJson());
        json.put("typergames", typerGamesToJson());
        return json;
    }

    // EFFECTS: returns NUmbergames in this profile as a JSON array
    private JSONArray numberGamesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (NumberGame n :numGames) {
            jsonArray.put(n.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns NUmbergames in this profile as a JSON array
    private JSONArray typerGamesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (TypingGame t :typeGames) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }


}
