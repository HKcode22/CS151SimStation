package prisonerdilemma;

import java.util.Random;

public class Prisoner extends simstation.Agent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    private Strategy strategy;

    public Prisoner(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean cooperate() {
        return strategy.decide();
    }

    @Override
    public void update() {
    }

    public void updateFitness(int amt) {
        fitness += amt;
    }
}
