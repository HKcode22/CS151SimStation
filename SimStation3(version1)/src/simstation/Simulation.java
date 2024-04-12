package simstation;
import java.util.Timer;
import java.util.TimerTask;

import mvc.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Simulation extends Model {
    private List<Agent> agents;
    private boolean running;

    private int width;
    private int height;

    transient private Timer timer; // timers aren't serializable
    private int clock;

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }

    public Simulation() {
        agents = new ArrayList<>();
        running = false;

    }

    public void addAgent(Agent agent) {
        agents.add(agent);
        changed();
    }

    public List<Agent> getAgents() {
        return agents;
    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


//    public void start() {
//        for (Agent agent : agents) {
//            agent.start();
//        }
//    }

    public boolean isRunning() {
        return running;
    }
//
//    public void start() {
//        for (Agent agent : agents) {
//            agent.start();
//        }
//
//        // Update the position of agents continuously
//        Thread updateThread = new Thread(() -> {
//            while (true) {
//                if (running) {
//                    for (Agent agent : agents) {
//                        agent.stop();
//                    }
//                    agents.clear();
//                    running = false;
//                }
//                changed();
//                try {
//                    Thread.sleep(Params.DELAY);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        updateThread.start();
//    }

//    public void start() {
//        System.out.println("Simulation started!"); // Debugging print statement
//        for (Agent agent : agents) {
//            agent.start();
//
//        }
//        changed();
//    }

    public void start() {
        if (!running) { // Check if the simulation is not already running
            running = true; // Update state to running
            System.out.println("Simulation started!"); // Debugging print statement

            for (Agent agent : agents) {
                agent.start();
            }

            Thread updateThread = new Thread(() -> {
                while (running) { // Continue updating agents while the simulation is running
                    for (Agent agent : agents) {
                        agent.update(); // Update agent positions
                    }
                    changed(); // Notify subscribers about changes
                    try {
                        Thread.sleep(Params.DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            updateThread.start();
        }
    }

    public void suspend() {
        for (Agent agent : agents) {
            agent.suspend();
        }
    }

    public void resume() {
        for (Agent agent : agents) {
            agent.resume();
        }
    }

    public void stop() {
        for (Agent agent : agents) {
            agent.stop();
        }
        agents.clear();
    }

}





// package simstation;
// import java.util.Timer;
// import java.util.TimerTask;

// import mvc.*;
// import java.util.ArrayList;
// import java.util.List;

// public class Simulation extends Model {

//     transient private Timer timer; // timers aren't serializable
//     private int clock;

//     private void startTimer() {
//         timer = new Timer();
//         timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
//     }

//     private void stopTimer() {
//         timer.cancel();
//         timer.purge();
//     }

//     private class ClockUpdater extends TimerTask {
//         public void run() {
//             clock++;
//         }
//     }
    
//     // etc.

//     public List<Agent> agents;

//     public boolean run;
    
//     public width;
//     public height;

//     public Simulation(){
//         agents = new ArrayList<>();
//         run = false;
//     }

//     public int getWidth() {
//         return width;
//     }

//     public int getHeight() {
//         return height;
//     }


//     public void addAgent(Agent agent){
//         agents.add(agent)
//     }

//     public List<Agent> getAgents(){
//         return agents
//     }

//     public boolean isRunning() {
//         return running;
//     }

//     public void start() {
//         if (!running) { // checking if simulatuon is running 
//             running = true; 
//             System.out.println("Simulation started!!!!"); 

//             for (Agent agent : agents) {
//                 agent.start();
//             }


//             Thread updateThread = new Thread(() -> {
//                 while (running) { // continue updating agents while simulation is runing
//                     for (Agent agent : agents) {
//                         agent.update(); 
//                     }
//                     changed();public void suspend() {
//         for (Agent agent : agents) {
//             agent.suspend();
//         }
//     }

//     public void resume() {
//         for (Agent agent : agents) {
//             agent.resume();
//         }
//     }

//     public void stop() {
//         for (Agent agent : agents) {
//             agent.stop();
//         }
//         agents.clear(); // Clear the list of agents
//     }

//     public void suspend() {
//         for (Agent agent : agents) {
//             agent.suspend();
//         }
//     }

//    public void stats() {
//         for (Agent agent : agents) {
//             agent.stats();
//         }
//     }
      

// }
