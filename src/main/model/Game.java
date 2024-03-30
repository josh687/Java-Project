package model;


import org.json.JSONObject;
import persistence.Writable;


public class Game implements Writable {
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
        EventLog.getInstance().logEvent(new Event("Game lost"));
    }

    public void resetLevel() {
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
            EventLog.getInstance().logEvent(new Event("new highscore set at " + highscore));
        }
    }

    public int getLevel() {
        return level;
    }


    //EFFECTS: sets level to i
    public void setLevel(int i) {
        level = i;
    }



    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Highscore", highscore);
        json.put("Level", level);
        return json;

    }



}
