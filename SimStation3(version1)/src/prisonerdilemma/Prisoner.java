package prisonerdilemma;

import simstation.Agent;

import java.util.Random;

public class Prisoner extends Agent {

    private int fitness = 0;
    private boolean cheated = false;
    private Strategy strategy;

    public Prisoner(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean cooperate(){
        return new Random().nextBoolean();
    }

    @Override
    public void update() { }

    public void updateFitness(int amt) { }

}
