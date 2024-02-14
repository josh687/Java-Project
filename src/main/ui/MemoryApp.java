package ui;

import model.NumberGame;
import model.Profile;
import model.TypingGame;

import java.util.ArrayList;
import java.util.Scanner;


public class MemoryApp {
    private NumberGame game;
    private Scanner input;
    private TypingGame typer;
    private ArrayList<Profile> profiles;


    public MemoryApp() {
        runGame();
    }

    public void runGame() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    private void processCommand(String command) {
        if (command.equals("p")) {
            playGame();
        } else if (command.equals("h")) {
            System.out.println(game.getHighScore());
        } else if (command.equals("t")) {
            playTypingGame();
        } else if (command.equals("a")) {
            accessProfiles();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    private void init() {
        game = new NumberGame();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        typer = new TypingGame();
        profiles = new ArrayList<Profile>();
    }

    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tp -> Play Game");
        System.out.println("\tt -> Play typing Game");
        System.out.println("\ta -> Access profiles");
        System.out.println("\tq -> quit");
    }

    private void playTypingGame() {
        String scen = typer.getScentence();
        System.out.println(scen);
        String in = input.next();
        if (scen.equals(in)) {
            typer.nextLevel();
            playTypingGame();
        } else {
            looseGameTyper();

        }

    }

    private void playGame() {
        int rand = game.getNumForLevel();
        System.out.println(rand);
        int num = input.nextInt();
        if (num == rand) {
            game.nextLevel();
            playGame();
        } else {
            looseGameNumber();

        }


    }


    public void accessProfiles() {
        System.out.println(("Type in what profile you want to access"));
        for (Profile prof : profiles) {
            System.out.println(prof.getName());
//            System.out.println(prof.getHighScore());
//            System.out.println(prof.getTypeHighScore());
        }
        String wantToAccessProfile = input.next();
        Profile accessedProfile = profiles.get(getProfPosition(wantToAccessProfile));
        accessedProfile.newHighScoreNum();
        accessedProfile.newHighScoreType();
        System.out.println("the Number Highscore For this profile is " + accessedProfile.getHighScore());
        System.out.println("the Typing Highscore For this profile is " + accessedProfile.getTypeHighScore());


    }

    public void looseGameTyper() {
        System.out.println("you loose");
        System.out.println("your score was " + typer.getLevel());
        System.out.println("Enter In profile to add game to");
        String prof = input.next();
        if (getProfPosition(prof) >= 0) {
            Profile profToAdd = profiles.get(getProfPosition(prof));
            profToAdd.addTypeGame(typer);
            profToAdd.newHighScoreType();
            typer.resetGame();
        } else {
            Profile profToAdd = new Profile(prof);
            profToAdd.addTypeGame(typer);
            profToAdd.newHighScoreType();
            profiles.add(profToAdd);
            typer = new TypingGame();
        }


    }

    public void looseGameNumber() {
        System.out.println("you loose");
        System.out.println("your score was " + game.getLevel());
        System.out.println("Enter In profile to add game to");
        String prof = input.next();
        if (getProfPosition(prof) >= 0) {
            Profile profToAdd = profiles.get(getProfPosition(prof));
            profToAdd.addNumGame(game);
            profToAdd.newHighScoreNum();

            game.resetGame();
        } else {
            Profile profToAdd = new Profile(prof);
            profToAdd.addNumGame(game);
            profToAdd.newHighScoreNum();
            profiles.add(profToAdd);

            game = new NumberGame();
        }

    }


    public boolean findProf(String name) {
        for (Profile profs : profiles) {
            if (profs.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Profile getProf(String name) {
        for (Profile profs : profiles) {
            if (profs.getName().equals(name)) {
                return profs;
            }
        }
        Profile profi = new Profile(name);
        return profi;
    }



    public int getProfPosition(String name) {
        int count = 0;
        for (Profile prof : profiles) {
            count++;
            if (name.equals(prof.getName())) {
                return count - 1;
            }
        }
        return -1;
    }
}



