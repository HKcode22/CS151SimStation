package randomwalk;

import mvc.AppPanel;
import simstation.*

public class RandomWalkSimulation extends Simulation {
    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Drunk(this));
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        panel.display();
    }
}
