package plague;
import simstation.*;

public class Organism extends Agent {
    private boolean infected;

    public Organism(boolean initialInfect) {
        this.infected = initialInfect;
    }

    public boolean isInfected() {
        return infected;
    }

    @Override
    public void update() {
        if (!infected) {
            Agent neighbor = this.world.getNeighbor(this, 10);
            if (neighbor instanceof Organism && ((Organism) neighbor).isInfected()) {
                attemptInfection();
            }
        }
    }

    private void attemptInfection() {
        if (Math.random() * 100 < PlagueSimulation.VIRULENCE) {
            if (Math.random() * 100 >= PlagueSimulation.RESISTANCE) {
                infected = true; // organism fails to resist
            }
        }
    }
}
