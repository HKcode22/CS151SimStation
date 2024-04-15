package simstation;
import java.util.*;

import mvc.*;

public abstract class Simulation extends Model {
    private List<Agent> agents;
    private boolean running;

    private int width;
    private int height;

    transient private Timer timer; // timers aren't serializable
    private int clock;

    protected void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    protected void stopTimer() {
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
        clock = 0;
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

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Agent getNeighbor(Agent a, double radius) {
        int startIndex = new Random().nextInt(agents.size());
        int currentIndex = startIndex;

        do {
            Agent currentAgent = agents.get(currentIndex);
            if (currentAgent != a && distanceBetweenAgents(a, currentAgent) <= radius) {
                return currentAgent;
            }
            currentIndex = (currentIndex + 1) % agents.size();
        } while (currentIndex != startIndex);

        return null;
    }

    private double distanceBetweenAgents(Agent agent1, Agent agent2) {
        double dx = agent1.getX() - agent2.getX();
        double dy = agent1.getY() - agent2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean isRunning() {
        return running;
    }

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

    public void populate() {};

}

