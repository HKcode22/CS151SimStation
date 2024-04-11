package simstation;
import mvc.*;

import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends AppPanel {
    private JButton start, suspend, resume,stop, stats;
    public SimulationPanel(AppFactory factory) {
        super(factory);
        JPanel bp = new JPanel();
        start = new JButton("Start");
        suspend = new JButton("Suspend");
        resume = new JButton("Resume");
        stop = new JButton("Stop");
        stats = new JButton("Stats");

        start.addActionListener(this);
        suspend.addActionListener(this);
        resume.addActionListener(this);
        stop.addActionListener(this);
        stats.addActionListener(this);

        // formatting the button layout
        bp.setLayout(new GridLayout(2,2,75,150));
        bp.setBackground(Color.LIGHT_GRAY);
        bp.add(start);
        bp.add(suspend);
        bp.add(resume);
        bp.add(stop);
        bp.add(stats);
        bp.setPreferredSize(new Dimension(275,200));

        controlPanel.add(bp);
        controlPanel.setBackground(Color.LIGHT_GRAY);
        viewPanel.setBackground(Color.GRAY);
    }
}

//package simstation;
//import mvc.*;
//import randomWalks.*;
//
//import javax.swing.*;
//
//public class SimulationPanel extends AppPanel {
//
//    public SimulationPanel(AppFactory factory) {
//        super(factory);
//        SimulationView simulationView; 
//
//        JButton startButton = new JButton("Start");
//        JButton suspendButton = new JButton("Suspend");
//        JButton resumeButton = new JButton("Resume");
//        JButton stopButton = new JButton("Stop");
//
//        startButton.addActionListener(e -> ((StartCommand) factory.makeEditCommand(getModel(), "Start", this)).execute());
////        suspendButton.addActionListener(e -> ((SuspendCommand) factory.makeEditCommand(getModel(), "Suspend", this)).execute());
////        resumeButton.addActionListener(e -> ((ResumeCommand) factory.makeEditCommand(getModel(), "Resume", this)).execute());
////        stopButton.addActionListener(e -> ((StopCommand) factory.makeEditCommand(getModel(), "Stop", this)).execute());
//
//        controlPanel.add(startButton);
//        controlPanel.add(suspendButton);
//        controlPanel.add(resumeButton);
//        controlPanel.add(stopButton);
//
//
//
//        simulationView = new SimulationView((Simulation) getModel());
//        add(simulationView);
//    }
//
//}

