package plague;
import mvc.*;
import simstation.*;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection

    public void populate() {
        for (int i = 0; i < 100; i++) {
            boolean initialInfect = Math.random() < 0.5; // 50% chance of initial infection
            this.addAgent(new Organism(initialInfect));
        }
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}
