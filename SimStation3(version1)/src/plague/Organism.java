package plague;
import mvc.*;
import simstation.*;
import java.util.List;

public class Organism extends Agent {
    private boolean infected, resistant;

    public Organism(Simulation world){
        super(world);
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
            // Check nearby agents and try to infect them
            Organism neighbor = (Organism)world.getNeighbor(this,20);
            if (!neighbor.isResistant() && !neighbor.isInfected()) {
                neighbor.setInfected(true);
            }
        }
    }

}
