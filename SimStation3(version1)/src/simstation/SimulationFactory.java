package simstation;
import mvc.*;

public abstract class SimulationFactory implements AppFactory {
    @Override
    public View makeView(Model m) {
        return new SimulationView(m);
    }

    @Override
    public String getAbout() {
        return "SimStation v.1.0. Copyright 2024 by simstation group 10 (Hamza, Nicole, Sandy)";
    }

    @Override
    public String[] getHelp() {
        return new String[]{
                "Start - runs the program\n"+
                        "Suspend - temporarily pauses the program\n" +
                        "Resume - unpauses the program\n" +
                        "Stop - stops the program\n"+
                        "Stats - shows the info of current simulation\n"
        };
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String name, Object source) {
        return switch (name) {
            case "Start" -> new StartCommand(model);
            case "Suspend" -> new SuspendCommand(model);
            case "Resume" -> new ResumeCommand(model);
            case "Stop" -> new StopCommand(model);
            case "Stats" -> new StatsCommand(model);
            default -> throw new IllegalArgumentException("Unexpected value: " + name);
        };
    }
}
