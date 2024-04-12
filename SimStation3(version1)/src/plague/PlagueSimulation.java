package plague;
import mvc.*;
import simstation.*;

// WORK IN PROGRESS
public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection

    public void populate() {
        for(int i = 0; i < 2; i++) // add the infected
            addAgent(new Host());
        for(int i = 0; i < 28; i++) // add the healthy
            addAgent(new Host());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}
