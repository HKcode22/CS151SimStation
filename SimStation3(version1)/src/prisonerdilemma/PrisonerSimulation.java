package prisonerdilemma;

import mvc.AppPanel;
import randomwalk.*;
import simstation.*;

import java.util.ArrayList;
import java.util.List;

public class PrisonerSimulation extends Simulation {

    private List<Prisoner> prisoners;

    public PrisonerSimulation() {
        prisoners = new ArrayList<>();
    }

    public PrisonerSimulation(int width, int height) {
        super();
        setWidth(width);
        setHeight(height);
        prisoners = new ArrayList<>();
    }

    public List<Prisoner> getPrisoners() {
        return prisoners;
    }

    public void addPrisoner(Prisoner prisoner) {
        prisoners.add(prisoner);
    }

    public void runSimulation(int rounds) {
        for (int i = 0; i < rounds; i++) {
            playRound();
        }
    }

    private void playRound() {
        for (int i = 0; i < prisoners.size(); i++) {
            for (int j = i + 1; j < prisoners.size(); j++) {
                Prisoner prisoner1 = prisoners.get(i);
                Prisoner prisoner2 = prisoners.get(j);

                boolean decision1 = prisoner1.makeDecision();
                boolean decision2 = prisoner2.makeDecision();

                if (decision1 && decision2) {
                    prisoner1.addPayoff(3);
                    prisoner2.addPayoff(3);
                } else if (decision1 && !decision2) {
                    prisoner1.addPayoff(0);
                    prisoner2.addPayoff(5);
                } else if (!decision1 && decision2) {
                    prisoner1.addPayoff(5);
                    prisoner2.addPayoff(0);
                } else {
                    prisoner1.addPayoff(1);
                    prisoner2.addPayoff(1);
                }
            }
        }



    }

    public static void main(String[] args) {
        PrisonerSimulation simulation = new PrisonerSimulation();

        simulation.setWidth(800);
        simulation.setHeight(600);

        Prisoner prisoner1 = new Prisoner(simulation);
        Prisoner prisoner2 = new Prisoner(simulation);

        prisoner1.setStrategy(new AlwaysCooperateStrategy());
        prisoner2.setStrategy(new AlwaysCheatStrategy());

        simulation.addPrisoner(prisoner1);
        simulation.addPrisoner(prisoner2);

        simulation.runSimulation(10);
        System.out.println("Prisoner 1 payoff: " + prisoner1.getPayoff());
        System.out.println("Prisoner 2 payoff: " + prisoner2.getPayoff());

//        SimulationView view = new SimulationView(new PrisonerSimulation());

        SimulationView view = new SimulationView(simulation);
        AppPanel panel = new SimulationPanel(new PrisonerFactory());
        panel.add(view);
        panel.display();






    }
}




// package prisonerdilemma;
// import simstation.*;

// public class /**/PrisonerSimulation extends Simulation {
// }
