package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import model.EventLog;
import model.ListOfProfiles;
import persistence.JsonReader;
import persistence.JsonWriter;

import model.TypingGame;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;


public class HomeTab extends Tab {
    private ListOfProfiles profiles;
    private static final String JSON_STORE = "./data/workroom.json";
    private JLabel greeting;


    //EFFECTS: constructs a home tab for console with buttons and a greeting
    public HomeTab(GameUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        placeGreeting();
        placeHomeButtons();
//        placeStatusButton();
    }

    //EFFECTS: creates greeting at top of console
    private void placeGreeting() {
        greeting = new JLabel("Welcome", JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);

    }

    //EFFECTS: creates Arrive and Leave buttons that change greeting message when clicked
    private void placeHomeButtons() {
        JButton b1 = new JButton("Save profiles");
        JButton b2 = new JButton("Load Profiles");

        JPanel buttonRow = formatButtonRow(b1);
        buttonRow.add(b2);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        b1.addActionListener(e -> {
            getController().saveStuff();


        });

        b2.addActionListener(e -> {
            for (model.Event next : EventLog.getInstance()) {
                System.out.println(next.toString() + "\n\n");
            }
            getController().accessStuff();



        });

        this.add(buttonRow);
    }



}