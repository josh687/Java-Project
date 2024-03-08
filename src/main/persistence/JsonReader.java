package persistence;

import model.*;

import java.util.ArrayList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ListOfProfiles read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseListOfProfiles(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private ListOfProfiles parseListOfProfiles(JSONObject jsonObject) {
        String name = jsonObject.getString("ListOfProfiles");
        ListOfProfiles prs = new ListOfProfiles();
        addProfiles(prs, jsonObject);
        return prs;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addProfiles(ListOfProfiles prs, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("profiles");
        for (Object json : jsonArray) {
            JSONObject nextProfile = (JSONObject) json;
            addProfile(prs, nextProfile);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addProfile(ListOfProfiles pr, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int numHighScore = jsonObject.getInt("number HighScore");
        int typeHighScore = jsonObject.getInt("Typer Highscore");
        Profile prof = new Profile(name);
        prof.setNumHighScore(numHighScore);
        prof.setTypeHighScore(typeHighScore);
        JSONArray numgames = jsonObject.getJSONArray("numbergames");
        for (Object json : numgames) {
            JSONObject nextNumGame = (JSONObject) json;
            addNumGameToProfile(prof,nextNumGame);
        }

        JSONArray typergames = jsonObject.getJSONArray("typergames");
        for (Object json : typergames) {
            JSONObject nextTypeGame = (JSONObject) json;
            addTyperGameToProfile(prof,nextTypeGame);
        }






        pr.add(prof);
    }


    //EFFECTS: Adds numgame to profile
    public void addNumGameToProfile(Profile prof, JSONObject jsonObject) {
        int num = jsonObject.getInt("Level");
        NumberGame numgame = new NumberGame();
        numgame.setLevel(num);
        prof.addNumGame(numgame);
    }

    //EFFECTS: Adds typegame to profile
    public void addTyperGameToProfile(Profile prof, JSONObject jsonObject) {
        int num = jsonObject.getInt("Level");
        TypingGame typeGame = new TypingGame();
        typeGame.setLevel(num);
        prof.addTypeGame(typeGame);
    }


}
