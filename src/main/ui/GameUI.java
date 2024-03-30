package ui;

import model.ListOfProfiles;

import model.NumberGame;
import model.TypingGame;
import model.Profile;
import persistence.JsonReader;
import persistence.JsonWriter;

import model.TypingGame;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Scanner;


import javax.swing.*;
import java.util.Scanner;



public class GameUI extends JFrame {
    public static final int HOME_TAB_INDEX = 0;
    public static final int GAMES_TAB_INDEX = 1;
    public static final int PROFILES_TAB_INDEX = 2;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private JTabbedPane sidebar;
    private static final String JSON_STORE = "./data/workroom.json";
    private NumberGame numgame;
    private Scanner input;
    private TypingGame typer;
    private ListOfProfiles profiles;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //MODIFIES: this
    //EFFECTS: creates SmartHomeUI, loads SmartHome appliances, displays sidebar and tabs
    public GameUI() {

        super("Memory Game App");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        profiles = new ListOfProfiles();
        numgame = new NumberGame();
        typer = new TypingGame();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);



        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);

        loadTabs();
        add(sidebar);

        setVisible(true);
    }

    //EFFECTS: returns ListOfProfiles object controlled by this UI
    public ListOfProfiles getListOfProfiles() {
        return profiles;
    }

    public NumberGame getNumgame() {
        return numgame;
    }

    public TypingGame getTypingGame() {
        return typer;
    }


    //MODIFIES: this
    //EFFECTS: adds home tab, settings tab and report tab to this UI
    private void loadTabs() {
        JPanel homeTab = new HomeTab(this);
        JPanel gameTab = new GameTab(this);
        JPanel profileTab = new ProfilesTab(this);
//        JPanel reportTab = new ProfilesTab(this);

        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
        sidebar.add(gameTab, GAMES_TAB_INDEX);
        sidebar.setTitleAt(GAMES_TAB_INDEX, "Games");
        sidebar.add(profileTab, PROFILES_TAB_INDEX);
        sidebar.setTitleAt(PROFILES_TAB_INDEX, "Profiles");
    }

    //EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }

    public void setLOP(ListOfProfiles lop) {
        this.profiles = lop;
    }

    public void saveStuff() {
        try {
            jsonWriter.open();
            jsonWriter.write(profiles);
            jsonWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    public void accessStuff() {
        try {
            profiles = jsonReader.read();
            System.out.println("Loaded "  + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}