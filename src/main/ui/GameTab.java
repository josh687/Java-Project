package ui;

import model.NumberGame;
import model.TypingGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ListOfProfiles;
import model.NumberGame;
import model.Profile;

public class GameTab extends Tab {


    private JLabel greeting;
    private NumberGame numgame;
    private TypingGame typer;
    private JLabel gameout;
    private JTextField input;
    private JScrollPane yer;
    private ListOfProfiles profiles;


    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public GameTab(GameUI controller) {
        super(controller);

        numgame = new NumberGame();
        typer = new TypingGame();


        setLayout(new GridLayout(3, 1));


        placeHomeButtons();
    }

    //EFFECTS: creates greeting at top of console


    //EFFECTS: creates Arrive and Leave buttons that change greeting message when clicked
    @SuppressWarnings("methodlength")
    private void placeHomeButtons() {
        JButton b1 = new JButton("Play NumberGame");
        JButton b2 = new JButton("Play Typing Game");

        JPanel buttonRow = formatButtonRow(b1);
        buttonRow.add(b2);
        buttonRow.setSize(WIDTH, HEIGHT / 6);
        b1.setVisible(true);
        b2.setVisible(true);
        b1.setEnabled(true);
        b2.setEnabled(true);

        b1.addActionListener(e -> {
            b1.setVisible(false);
            b2.setVisible(false);
            b1.setEnabled(false);
            b2.setEnabled(false);

            playNumberGame();


        });

        b2.addActionListener(e -> {
            b1.setVisible(false);
            b2.setVisible(false);
            b1.setEnabled(false);
            b2.setEnabled(false);

            playTypingGame();

        });

        this.add(buttonRow);
    }

    @SuppressWarnings("methodlength")
    public void playNumberGame() {
        int rand = numgame.getNumForLevel();
        gameout = new JLabel(String.valueOf(rand), JLabel.CENTER);
        gameout.setSize(WIDTH, HEIGHT / 3);
        this.add(gameout);

        input = new JTextField(15);  // Create the JTextField

        JButton submitButton = new JButton("Submit");  // Create a button to submit the input
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(input.getText());  // Read the value from the JTextField
                if (num == rand) {
                    numgame.nextLevel();
                    removeAllPanels();
                    Container parent = gameout.getParent();
                    parent.remove(gameout);
                    parent.validate();
                    parent.repaint();
                    playNumberGame();
                } else {
                    removeAllPanels();
                    Container parent = gameout.getParent();
                    parent.remove(gameout);
                    parent.validate();
                    parent.repaint();
                    looseNumberGame();
                    
                }
            }
        });

        JPanel inputPanel = new JPanel();  // Create a panel to hold the input components
        inputPanel.add(new JLabel("Enter the number:"));
        inputPanel.add(input);
        inputPanel.add(submitButton);

        this.add(inputPanel);
          //  looseGameNumber();

        //}
    }

    private void removeAllPanels() {
        Component[] components = this.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                this.remove(component);
            }
        }
        this.revalidate();
        this.repaint();
    }

    @SuppressWarnings("methodlength")
    public void looseNumberGame() {


        input = new JTextField(15);  // Create the JTextField

        JButton submitButton = new JButton("Submit");  // Create a button to submit the input
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profiles = getController().getListOfProfiles();
                String prof = (input.getText());
                if (profiles.getProfPosition(prof) >= 0) {
                    Profile profToAdd = profiles.get(profiles.getProfPosition(prof));
                    profToAdd.addNumGame(numgame);
                    profToAdd.newHighScoreNum(numgame.getLevel());
                    numgame = new NumberGame();
                    removeAllPanels();


                } else {
                    Profile profToAdd = new Profile(prof);
                    profToAdd.addNumGame(numgame);
                    profToAdd.newHighScoreNum(numgame.getLevel());
                    profiles.add(profToAdd);
                    removeAllPanels();

                    numgame = new NumberGame();
                    placeHomeButtons();
                }
            }
        });

        JPanel inputPanel = new JPanel();  // Create a panel to hold the input components
        inputPanel.add(new JLabel("Enter the profile to add the game to"));
        inputPanel.add(input);
        inputPanel.add(submitButton);

        this.add(inputPanel);
        
    }


    @SuppressWarnings("methodlength")
    public void playTypingGame() {
        String rando = typer.getScentence();
        gameout = new JLabel(rando, JLabel.CENTER);
        gameout.setSize(WIDTH, HEIGHT / 3);
        this.add(gameout);

        input = new JTextField(15);  // Create the JTextField

        JButton submitButton = new JButton("Submit");  // Create a button to submit the input
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String in = (input.getText());  // Read the value from the JTextField
                if (in.equals(rando)) {
                    typer.nextLevel();
                    removeAllPanels();
                    Container parent = gameout.getParent();
                    parent.remove(gameout);
                    parent.validate();
                    parent.repaint();
                    playTypingGame();
                } else {
                    removeAllPanels();
                    Container parent = gameout.getParent();
                    parent.remove(gameout);
                    parent.validate();
                    parent.repaint();
                    looseTypingGame();

                }
            }
        });

        JPanel inputPanel = new JPanel();  // Create a panel to hold the input components
        inputPanel.add(new JLabel("Enter the number:"));
        inputPanel.add(input);
        inputPanel.add(submitButton);

        this.add(inputPanel);
        //  looseGameNumber();

        //}
    }



    @SuppressWarnings("methodlength")
    public void looseTypingGame() {


        input = new JTextField(15);  // Create the JTextField

        JButton submitButton = new JButton("Submit");  // Create a button to submit the input
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profiles = getController().getListOfProfiles();
                String prof = (input.getText());
                if (profiles.getProfPosition(prof) >= 0) {
                    Profile profToAdd = profiles.get(profiles.getProfPosition(prof));
                    profToAdd.addTypeGame(typer);
                    profToAdd.newHighScoreType(typer.getLevel());
                    typer = new TypingGame();
                    removeAllPanels();


                } else {
                    Profile profToAdd = new Profile(prof);
                    profToAdd.addTypeGame(typer);
                    profToAdd.newHighScoreType(typer.getLevel());
                    profiles.add(profToAdd);
                    removeAllPanels();

                    typer = new TypingGame();
                    placeHomeButtons();
                }
            }
        });

        JPanel inputPanel = new JPanel();  // Create a panel to hold the input components
        inputPanel.add(new JLabel("Enter the profile to add the game to"));
        inputPanel.add(input);
        inputPanel.add(submitButton);

        this.add(inputPanel);

    }






        




}