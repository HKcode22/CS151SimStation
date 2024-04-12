package simstation;

import java.io.Serializable;

enum Heading {
    NORTH, SOUTH, EAST, WEST
}

public abstract class Agent implements Runnable, Serializable {
    private String name;
    private Heading heading;
    private int xc;
    private int yc;
    private boolean suspended = false;
    private boolean stopped = false;
    private Thread myThread;

    public Agent(String name, Heading heading, int xc, int yc) {
        this.name = name;
        this.heading = heading;
        this.xc = xc;
        this.yc = yc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Heading getHeading() {
        return heading;
    }

    public void setHeading(Heading heading) {
        this.heading = heading;
    }

    public int getXc() {
        return xc;
    }

    public void setXc(int xc) {
        this.xc = xc;
    }

    public int getYc() {
        return yc;
    }

    public void setYc(int yc) {
        this.yc = yc;
    }

    public void onStart() {}
    public void onInterrupted() {}
    public void onExit() {}

    @Override
    public void run() {
        onStart();
        while (!stopped) {
            if (!suspended) {
                update();
                move(1);
            }
        }
        onExit();
    }

    public abstract void update();

    public void move(int steps) {
        switch (heading) {
            case NORTH:
                yc -= steps;
                break;
            case SOUTH:
                yc += steps;
                break;
            case EAST:
                xc += steps;
                break;
            case WEST:
                xc -= steps;
                break;
        }
    }

    public void start() {
        myThread = new Thread(this);
        myThread.start();
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;
    }

    public void stop() {
        stopped = true;
    }
}

