
package simstation;

import mvc.Command;
import mvc.Model;

public class StartCommand extends Command {

    public StartCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        System.out.println("Start button clicked!"); // Debugging print statement
        ((Simulation) model).start();
    }


}


// package simstation;

// import mvc.Command;
// import mvc.Model;

// public class StartCommand extends Command {

//     public StartCommand(Model model) {
//         super(model);
//     }

//     @Override
//     public void execute() {
//         // Start the simulation
//         ((Simulation) model).start();
//     }
// }
