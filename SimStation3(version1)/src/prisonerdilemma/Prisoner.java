package prisonerdilemma;

import mvc.Utilities;
import simstation.*;

import java.util.List;
import java.util.Random;

public class Prisoner extends Agent {
    private int fitness = 0;
    private boolean cheated = false;
    private Strategy strategy;
    private int payoff;

    public void addPayoff(int payoff) {
        this.payoff += payoff;
    }

    public boolean makeDecision() {
        return strategy.decide();
    }

    public int getPayoff() {
        return payoff;
    }

//    public Prisoner(Strategy strategy) {
//        super(world); // Pass null as the Simulation object for now
//        this.strategy = strategy;
//    }

    public Prisoner(Simulation world) {
        super(world);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean isCooperator() {
        return strategy instanceof AlwaysCooperateStrategy;
    }




//    public Prisoner(Strategy strategy) {
//        super(null);
//        this.strategy = strategy;
//    }
    public boolean cooperate(){
        return new Random().nextBoolean();
    }

    @Override
    public void update() {
//        if (isCooperator()) {
//            updateFitness(1);
//        } else {
//            updateFitness(-1);
//        }
        int dx = Utilities.rng.nextInt(3) - 1;
        int dy = Utilities.rng.nextInt(3) - 1;

        int newX = Math.max(0, Math.min(getXc() + dx, world.getWidth() - 1));
        int newY = Math.max(0, Math.min(getYc() + dy, world.getHeight() - 1));
        coord.setLocation(newX, newY);
    }

    public void updateFitness(int amt) {
        fitness+=amt;
    }

}




// package prisonerdilemma;

// import simstation.Agent;

// import java.util.Random;

// public class Prisoner extends Agent {

//     private int fitness = 0;
//     private boolean cheated = false;
//     private Strategy strategy;

//     public Prisoner(Strategy strategy) {
//         this.strategy = strategy;
//     }

//     public boolean cooperate(){
//         return new Random().nextBoolean();
//     }

//     @Override
//     public void update() { }

//     public void updateFitness(int amt) { }

// }
