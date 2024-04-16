/*
package plague;
import mvc.*;
import simstation.*;
import java.util.List;

public class Organism extends Agent {
    private boolean infected, resistant;
    public Simulation world;

    public Organism(Simulation world){
        this.world = world;
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

    public void update() {
        if (infected) {
            List<Agent> neighbors = world.getNeighbor(this, 2000);
            for (Agent neighbor : neighbors) {
                if (neighbor instanceof Organism orgNeighbor) {
                    if (Utilities.rng.nextInt(100) < PlagueSimulation.VIRULENCE && !orgNeighbor.isResistant()) {
                        orgNeighbor.setInfected(true); // organism fails to resist
                    }
                }
            }
        }
    }

}
*/
