package simstation;
import mvc.*;

import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends AppPanel {

    public SimulationPanel(AppFactory factory) {
        super(factory);

        JButton startButton = new JButton("Start");
        JButton suspendButton = new JButton("Suspend");
        JButton resumeButton = new JButton("Resume");
        JButton stopButton = new JButton("Stop");

        startButton.addActionListener(this);
        controlPanel.add(startButton);
        controlPanel.add(suspendButton);
        controlPanel.add(resumeButton);
        controlPanel.add(stopButton);

        view.setBackground(Color.GRAY);
    }

}


