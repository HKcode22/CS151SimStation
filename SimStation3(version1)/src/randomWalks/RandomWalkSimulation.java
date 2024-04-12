package randomWalks;

import mvc.*;
import simstation.*;
import simstation.SimulationFactory;

public class RandomWalkSimulation extends Simulation {
    public RandomWalkSimulation() {
        populate();
    }
    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Drunk());
    }


    public static void main(String[] args) {
        SimulationView view = new SimulationView(new RandomWalkSimulation());
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
//        panel.add(view);
        panel.display();
    }
}









// package randomWalks;
// import mvc.*;
// import simstation.*;
// import java.awt.*;
// import java.util.Iterator;

// public class RandomWalkSimulation {
//     public void populate() {
//         for(int i = 0; i < 15; i++)
//             addAgent(new Drunk());
//     }

//     public static void main(String[] args) {
//         AppPanel panel = new SimulationPanel(new RandomWalkFactory());
//         panel.display();
//     }
// }
