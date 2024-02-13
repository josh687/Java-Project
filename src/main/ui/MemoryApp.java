package ui;

import model.NumberGame;
import model.Profile;
import model.TypingGame;

import java.util.ArrayList;
import java.util.Scanner;


public class MemoryApp {
    private Profile profile;
    private NumberGame game;
    private Scanner input;
    private TypingGame typer;


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
        } else {
            System.out.println("Selection not valid...");
        }
    }

    private void init() {
        game = new NumberGame();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        typer = new TypingGame();
    }

    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tp -> Play Game");
        System.out.println("\tt -> Play typing Game");
        System.out.println("\th -> Get High Score");
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
            System.out.println("you loose");
            System.out.println("your score was " + typer.getLevel());
            typer.resetGame();
            System.out.println("your highscore in this game is " + typer.getHighScore());

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
            System.out.println("you loose");
            System.out.println("your score was " + game.getLevel());
            game.resetGame();
            System.out.println("your highscore in this game is " + game.getHighScore());

        }

    }

}