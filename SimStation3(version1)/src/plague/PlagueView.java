package plague;

import mvc.*;
import simstation.*;

import java.awt.*;
import java.util.List;

public class PlagueView extends SimulationView {
    private Simulation simulation;
    public PlagueView(Model model) {
        super(model);
        if (model instanceof PlagueSimulation) {
            this.simulation = (PlagueSimulation) model;
        } else {
            throw new IllegalArgumentException("Model must be an instance of PlagueSimulation");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        List<Agent> agents = simulation.getAgents();
        for (Agent agent : agents) {
            if(agent instanceof Organism) {
                Organism org = (Organism) agent;
                if (org.isInfected())
                    g.setColor(Color.RED);
                else
                    g.setColor(Color.GREEN);
                g.fillOval(org.getXc(), org.getYc(), 10, 10); // Draw a small oval as a dot
            }
        }
    }
}
