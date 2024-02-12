package ui;

import model.Game;

import java.util.Scanner;


public class MemoryApp {
    private Game game;
    private Scanner input;

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
        } else {
            System.out.println("Selection not valid...");
        }
    }

    private void init() {
        game = new Game();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tp -> Play Game");
        System.out.println("\th -> Get High Score");
        System.out.println("\tq -> quit");
    }

    private void playGame() {
        int rand = game.getNumForLevel();
        System.out.println(rand);
        int num = input.nextInt();
        if (num == rand) {
            game.nextLevel();
            playGame();
        } else {
            game.resetGame();
            System.out.println("you loose");
        }

    }

}