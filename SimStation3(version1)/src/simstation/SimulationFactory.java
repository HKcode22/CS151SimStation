package simstation;
import mvc.*;

public abstract class SimulationFactory implements AppFactory {
    @Override
    public abstract Model makeModel();

    @Override
    public abstract View makeView(Model model);

    @Override
    public String getTitle() {
        return "SIMSTATION";
    }

    @Override
    public String[] getHelp() {
        return new String[]{""};
    }

    @Override
    public String about() {
        return "SIMSTATION PROGRAM";
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"start","suspend","resume","stop", "stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type) {
            case "start":
                return new StartCommand(model);
            case "suspend":
                return new SuspendCommand(model);
            case "resume":
                return new ResumeCommand(model);
            case "stop":
                return new StopCommand(model);
            case "stats":
                return new StatsCommand(model);
        }
        return null;
    }
}
