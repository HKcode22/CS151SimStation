package simstation;
import mvc.*;

public enum Heading {
    NORTH, SOUTH, EAST, WEST;

    public static Heading random() {
        Heading[] headings = Heading.values();
        int randomIndex = Utilities.rng.nextInt(headings.length);
        return headings[randomIndex];
    }

    public Heading turnLeft() {
        switch (this) {
            case NORTH: return WEST;
            case SOUTH: return EAST;
            case EAST: return NORTH;
            case WEST: return SOUTH;
            default: throw new IllegalStateException("Unknown heading: " + this);
        }
    }

    public Heading turnRight() {
        switch (this) {
            case NORTH: return EAST;
            case SOUTH: return WEST;
            case EAST: return SOUTH;
            case WEST: return NORTH;
            default: throw new IllegalStateException("Unknown heading: " + this);
        }
    }
}
