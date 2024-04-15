package plague;
import mvc.*;
import simstation.*;

public class Organism extends Agent {
    private boolean infected, resistant;

    public Organism(){
        resistant = Utilities.rng.nextInt(100) < PlagueSimulation.RESISTANCE;
        infected = !resistant && Utilities.rng.nextInt(100) < PlagueSimulation.VIRULENCE;
    }

    public boolean isInfected() {
        return infected;
    }

    public boolean isResistant(){
        return resistant;
    }

    public void setInfected(boolean b){
        infected = b;
    }

    @Override
    public void update() {
        if (infected) {
            // try to infect a neighbor
            Agent neighbor = world.getNeighbor(this, 10);
            if (neighbor != null && neighbor instanceof Organism) {
                Organism orgNeighbor = (Organism) neighbor;
                if (Utilities.rng.nextInt(100) < PlagueSimulation.VIRULENCE && !orgNeighbor.isResistant()) {
                    orgNeighbor.setInfected(true); // organism fails to resist
                }
            }
        }
    }
}

}
