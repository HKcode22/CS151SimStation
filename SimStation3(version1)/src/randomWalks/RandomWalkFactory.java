package randomWalks;



import simstation.*;
import mvc.*;

public class RandomWalkFactory extends SimulationFactory {
    @Override
    public Model makeModel() {
        return new RandomWalkSimulation();
    }

    @Override
    public View makeView(Model model) {
            return new SimulationView((Simulation) model);

    }

    @Override
    public String getTitle() {
        return "Random Walks";
    }

    @Override
    public String[] getHelp() {
        // Return empty array for now
        return new String[0];
    }

    @Override
    public String about() {
        // Return a default message for now
        return "Random Walks Simulation";
    }

    @Override
    public String[] getEditCommands() {
        // Return empty array for now
        return new String[0];
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        // Return null or appropriate Command object based on the type
        switch (type) {
            case "Start":
                return new StartCommand(model);
            default:
                return null;
        }
    }
}







// package randomWalks;
// import mvc.*;
// import simstation.*;
// import java.awt.*;
// import java.util.Iterator;

// class RandomWalkFactory extends SimulationFactory {
//     public Model makeModel() { return new RandomWalkSimulation(); }
//     public String getTitle() { return "Random Walks";}
// }
