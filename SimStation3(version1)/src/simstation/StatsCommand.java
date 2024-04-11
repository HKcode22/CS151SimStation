package simstation;
import mvc.Command;
import mvc.Model;

public class StatsCommand extends Command {
    public StatsCommand(Model model) {
        super(model);
    }

    public void execute() {
        Simulation sim = (Simulation)model;
        sim.startTimer();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sim.stopTimer();
    }
}


//package simstation;
//
//import mvc.Command;
//import mvc.Model;
//
//public class StartCommand extends Command {
//
//    public StartCommand(Model model) {
//        super(model);
//    }
//
//    @Override
//    public void execute() {
//        System.out.println("Start button clicked!"); // Debugging print statement
//        ((Simulation) model).start();
//    }
//
//
//}
