package simstation;
import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SimulationView extends View {
    private Simulation simulation;

    public SimulationView(Model model) {
        super(model);
        if (model instanceof Simulation) {
            this.simulation = (Simulation) model;
        } else {
            throw new IllegalArgumentException("Model must be an instance of Simulation");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        List<Agent> agents = simulation.getAgents();
        for (Agent agent : agents) {
            g.setColor(Color.WHITE);
            g.fillOval(agent.getXc(), agent.getYc(), 10, 10); // Draw a small oval as a dot
        }
    }

    @Override
    public void update() {
        repaint();
    }
}