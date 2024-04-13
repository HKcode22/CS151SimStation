package prisonerdilemma;

public interface Strategy {
    boolean decide();
}

class AlwaysCooperateStrategy implements Strategy {
    @Override
    public boolean decide() {
        return true;
    }
}

class AlwaysCheatStrategy implements Strategy {
    @Override
    public boolean decide() {
        return false;
    }
}

class RandomCooperateStrategy implements Strategy {
    @Override
    public boolean decide() {
        return Math.random() < 0.5; // Cooperate with a probability of 0.5
    }
}

class TitForTatStrategy implements Strategy {
    private boolean lastOpponentCooperated;

    public TitForTatStrategy(boolean lastOpponentCooperated) {
        this.lastOpponentCooperated = lastOpponentCooperated;
    }

    @Override
    public boolean decide() {
        return lastOpponentCooperated;
    }
}