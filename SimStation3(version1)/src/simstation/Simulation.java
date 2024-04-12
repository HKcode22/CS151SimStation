package simstation;
import mvc.*;
import java.util.*;

public class Simulation extends Model {
    private int clock;
    private List<Agent> agents = new ArrayList<>();
    transient private Timer timer;

    public Simulation() {
        clock = 0;
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
        changed();
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public synchronized void start() {
        startTimer();
        populate();
        for (Agent agent : agents) {
            agent.start();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

    protected void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    protected void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    public Agent getNeighbor(Agent a, double radius) {
        return null;
    }

    public void populate() { }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }
}

