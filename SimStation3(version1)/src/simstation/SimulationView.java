package simstation;

import mvc.Model;
import mvc.View;

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
            g.fillOval(agent.getX(), agent.getY(), 10, 10); // Draw a small oval as a dot
        }
    }

    @Override
    public void update() {
        repaint();
    }
}






// package simstation;

// import mvc.View;

// import javax.swing.*;
// import java.awt.*;
// import java.util.List;

// public class SimulationView extends View {
//     public Simulation simulation;

//     public SimulationView(Simulation model) {
//         super(model);
//         this.simulation = model;
//     }

//     @Override
//     protected void paintComponent(Graphics gc) {
//         super.paintComponent(gc);

//         List<Agent> agents = simulation.getAgents();

//         // Draw each agent as a dot on the screen
//         for (Agent agent : agents) {
//             gc.setColor(Color.WHITE); // Set dot color
//             gc.fillRect(agent.getX(), agent.getY(), 5, 5); // Draw a small rectangle as a dot
//         }
//     }
// }
