package ui;

import ui.GameUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;

public abstract class Tab extends JPanel {

    private final GameUI controller;

    //REQUIRES: SmartHomeUI controller that holds this tab
    public Tab(GameUI controller) {
        this.controller = controller;
    }

    //EFFECTS: creates and returns row with button included
    public JPanel formatButtonRow(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

    //EFFECTS: returns the SmartHomeUI controller for this tab
    public GameUI getController() {
        return controller;
    }


}