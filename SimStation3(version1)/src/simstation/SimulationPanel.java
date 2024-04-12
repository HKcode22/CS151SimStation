package simstation;
import mvc.*;
import javax.swing.*;
import java.awt.*;

public class SimulationPanel extends AppPanel {
    public SimulationPanel(AppFactory factory) {
        super(factory);
        JButton start = new JButton("start");
        start.addActionListener(this);
        JButton suspend = new JButton("suspend");
        suspend.addActionListener(this);
        JButton resume = new JButton("resume");
        resume.addActionListener(this);
        JButton stop = new JButton("stop");
        stop.addActionListener(this);
        JButton stats = new JButton("stats");
        stats.addActionListener(this);

        controlPanel.add(start);
        controlPanel.add(suspend);
        controlPanel.add(resume);
        controlPanel.add(stop);
        controlPanel.add(stats);

        view.setBackground(Color.GRAY);
    }
}
