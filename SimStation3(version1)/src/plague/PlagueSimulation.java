package plague;
import mvc.*;
import randomWalks.*;
import randomWalks.RandomWalkSimulation;
import simstation.*;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection

    public PlagueSimulation() {
        populate();
    }

    public void populate() {
        for (int i = 0; i < 25; i++) {
            this.addAgent(new Organism(this));
        }
    }


    public static void main(String[] args) {
        SimulationView view = new SimulationView(new PlagueSimulation());
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}





// package plague;
// import mvc.*;
// import simstation.*;

// public class PlagueSimulation extends Simulation {
//     public static int VIRULENCE = 50; // % chance of infection
//     public static int RESISTANCE = 2; // % chance of resisting infection

//     public void populate() {
//         for (int i = 0; i < 25; i++) {
//             this.addAgent(new Organism());
//         }
//     }

//     public static void main(String[] args) {
//         AppPanel panel = new SimulationPanel(new PlagueFactory());
//         panel.display();
//     }
// }
