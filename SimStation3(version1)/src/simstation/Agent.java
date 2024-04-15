package simstation;

import mvc.*;

public abstract class Agent implements Runnable {
    protected int x, y;
    protected Heading heading;
    protected Simulation world;
    protected boolean suspended;
    transient protected Thread myThread;

    protected boolean isRunning;


    public Agent() {
        this.world = world;
        x = Utilities.rng.nextInt(Params.WORLD_WIDTH);
        y = Utilities.rng.nextInt(Params.WORLD_HEIGHT);
        suspended = false;
        myThread = new Thread(this);
    }

    public void run() {
        onStart();
        while (!suspended) {
            update();
            try {
                Thread.sleep(Params.DELAY);
            } catch (InterruptedException e) {
                onInterrupted();
            }
        }
        onExit();
    }

    public abstract void update();

    public void start() {
        if (!isRunning) {
            myThread.start();
            isRunning = true;
        }
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;
    }

    public void stop() {
        myThread.interrupt();
        onExit();
    }

    protected void move(int steps) {
        switch (heading) {
            case NORTH:
                y = Math.max(0, y - steps);
                break;
            case SOUTH:
                y = Math.min(Params.WORLD_HEIGHT, y + steps);
                break;
            case EAST:
                x = Math.min(Params.WORLD_WIDTH, x + steps);
                break;
            case WEST:
                x = Math.max(0, x - steps);
                break;
        }
        world.changed();
    }

    protected void onStart(){
    }

    protected void onInterrupted() {
    }

    protected void onExit() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void changeHeading(Heading newHeading) {
        heading = newHeading;
    }
}

