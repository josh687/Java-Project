package ui;

import model.NumberGame;
import model.Profile;
import model.TypingGame;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Scanner;


public class MemoryApp {
    private NumberGame game;
    private Scanner input;
    private TypingGame typer;
    private ArrayList<Profile> profiles;

    // some code from TellerApp from CPSC 210

    //Runs the application
    public MemoryApp() {
        runGame();
    }


    //Modifies: This
    //EFFECTS: Processess user input
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

    // EFFECTS: runs the operation depending on user input
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

    //EFFECTS :Initializes the games and fields
    private void init() {
        game = new NumberGame();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        typer = new TypingGame();
        profiles = new ArrayList<>();
    }

    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tp -> Play Game");
        System.out.println("\tt -> Play typing Game");
        System.out.println("\ta -> Access profiles");
        System.out.println("\tq -> quit");
    }

    //MODIFIES: THIS
    //EFFECTS: adds 1 level to typing game if user wins, and goes to next level, otherwise looseGameTyper()
    private void playTypingGame() {
        String scen = typer.getScentence();
        System.out.println(scen);
        printAfterLevelSecondsTyper();

        String in = input.next();
        if (scen.equals(in)) {
            typer.nextLevel();
            playTypingGame();
        } else {
            looseGameTyper();

        }

    }

    //MODIFIES: THIS
    //EFFECTS: adds 1 level to Number game if user wins, and goes to next level, otherwise LoosGameNumber()
    private void playGame() {
        int rand = game.getNumForLevel();
        System.out.println(rand);
        printAfterLevelSeconds();
        int num = input.nextInt();
        if (num == rand) {
            game.nextLevel();
            playGame();
        } else {
            looseGameNumber();

        }
    }

    //effects; Delays program in terminal based on level
    public void printAfterLevelSeconds() {
        try {

            Thread.sleep(100 + game.getLevel() * 500);


            System.out.println("\n\n\n\n\n\n\n");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    //effects; Delays program in terminal based on level
    public void printAfterLevelSecondsTyper() {
        try {

            Thread.sleep(100 + typer.getLevel() * 500);


            System.out.println("\n\n\n\n\n\n\n");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }






// Displays user stats depending on what user wants
    @SuppressWarnings("methodlength")
    public void accessProfiles() {


        if (profiles.isEmpty()) {
            System.out.println("play a game with a profile first");
        } else {
            System.out.println(("Type in what profile you want to access"));
            for (Profile prof : profiles) {
                System.out.println(prof.getName());
            }
            String wantToAccessProfile = input.next();
            Profile accessedProfile = profiles.get(getProfPosition(wantToAccessProfile));
            System.out.println("\nSelect from:");
            System.out.println("\th -> get High Scores");
            System.out.println("\tv -> view all games scores");
            String option = input.next();
            if (option.equals("h")) {
                System.out.println("the Number Highscore For this profile is " + accessedProfile.getHighScore());
                System.out.println("the Typing Highscore For this profile is " + accessedProfile.getTypeHighScore());
            } else if (option.equals("v")) {
                System.out.println("Here Are the scores for typing Games");
                for (TypingGame game1 : accessedProfile.getTypeGames()) {
                    System.out.println(game1.getLevel());
                }
                System.out.println("Here Are the scores for Number Games");
                for (NumberGame game2 : accessedProfile.getNumGames()) {
                    System.out.println(game2.getLevel());
                }
            }
        }
    }

    //MODIFIES: this
    //Effects Either adds typing game to old profile, or adds game to a new created profile
    public void looseGameTyper() {
        System.out.println("you loose");
        System.out.println("your score was " + typer.getLevel());
        System.out.println("Enter In profile to add game to");
        String prof = input.next();
        if (getProfPosition(prof) >= 0) {
            Profile profToAdd = profiles.get(getProfPosition(prof));
            profToAdd.addTypeGame(typer);
            profToAdd.newHighScoreType(typer.getLevel());
            typer = new TypingGame();
        } else {
            Profile profToAdd = new Profile(prof);
            profToAdd.addTypeGame(typer);
            profToAdd.newHighScoreType(typer.getLevel());
            profiles.add(profToAdd);
            typer = new TypingGame();
        }


    }

    //MODIFIES: this
    //Effects Either adds Number game to old profile, or adds game to a new created profile
    public void looseGameNumber() {
        System.out.println("you loose");
        System.out.println("your score was " + game.getLevel());
        System.out.println("Enter In profile to add game to");
        String prof = input.next();
        if (getProfPosition(prof) >= 0) {
            Profile profToAdd = profiles.get(getProfPosition(prof));
            profToAdd.addNumGame(game);
            profToAdd.newHighScoreNum(game.getLevel());
            game = new NumberGame();
        } else {
            Profile profToAdd = new Profile(prof);
            profToAdd.addNumGame(game);
            profToAdd.newHighScoreNum(game.getLevel());
            profiles.add(profToAdd);

            game = new NumberGame();
        }

    }

    //Finds where in the list of profile a peticular profile is, returns -1 if there is no profile.
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



