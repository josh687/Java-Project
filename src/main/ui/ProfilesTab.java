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


public class ProfilesTab extends Tab {

    private JLabel greeting;
    private NumberGame numgame;
    private TypingGame typer;
    private JLabel profs;
    private JTextField input;
    private JScrollPane yer;
    private ListOfProfiles profiles;
    private Profile accessedProfile;


    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public ProfilesTab(GameUI controller) {
        super(controller);

        numgame = new NumberGame();
        typer = new TypingGame();


        setLayout(new GridLayout(3, 1));


        placeHomeButtons();
    }


    public void placeHomeButtons() {
        JButton b1 = new JButton("acess Profiles");
        JPanel buttonRow = formatButtonRow(b1);
        buttonRow.setSize(WIDTH, HEIGHT / 6);
        b1.setVisible(true);
        b1.setEnabled(true);

        b1.addActionListener(e -> {

            b1.setVisible(false);
            b1.setEnabled(false);
            acessProfiles();

        });
        this.add(buttonRow);
    }

    @SuppressWarnings("methodlength")
    public void acessProfiles() {
        profiles = getController().getListOfProfiles();
        String lop = "";
        for (Profile prof : profiles.getProfiles()) {
            lop = lop + "\n" + prof.getName();

        }
        profs = new JLabel(lop, JLabel.CENTER);
        profs.setSize(WIDTH, HEIGHT / 3);
        this.add(profs);

        input = new JTextField(15);

        JButton submitButton = new JButton("Submit");  // Create a button to submit the input
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wantToAccessProfile = (input.getText());  // Read the value from the JTextField
                accessedProfile = profiles.get(profiles.getProfPosition(wantToAccessProfile));
                displayScores();
                Container parent = profs.getParent();
                parent.remove(profs);
                parent.validate();
                parent.repaint();
                removeAllPanels();






            }
        });





        JPanel inputPanel = new JPanel();  // Create a panel to hold the input components
        inputPanel.add(new JLabel("profile to acess"));
        inputPanel.add(input);

        inputPanel.add(submitButton);

        this.add(inputPanel);
    }

    public void displayScores() {
        JLabel slec = new JLabel("The Typing high score for this profile is: "
                +  accessedProfile.getTypeHighScore());
        JLabel high = new JLabel("The Number high score for this profile is: "
                +  accessedProfile.getHighScore());
        slec.setSize(WIDTH, HEIGHT / 3);
        high.setSize(WIDTH, HEIGHT / 3);
        this.add(slec);
        this.add(high);
        JButton back = new JButton("GoBack");
        JPanel br = formatButtonRow(back);
        br.setSize(WIDTH, HEIGHT / 6);
        back.setVisible(true);
        back.addActionListener(e -> {

            Container parent = back.getParent();
            parent.remove(back);
            parent.validate();
            parent.repaint();
            removeButton(slec);
            removeButton(high);
            removeAllPanels();
            placeHomeButtons();

        });
        this.add(back);
        this.add(br);


    }

    private void removeButton(JLabel but) {
        Container parent = but.getParent();
        parent.remove(but);
        parent.validate();
        parent.repaint();

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



}