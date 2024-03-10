package model;

public class RacingCar {

    private static final int MOVE_THRESHOLD = 4;
    private static final String MOVEMENT_INDICATOR = "-";
    private static final String STATUS_DELIMITER = " : ";

    private int location;
    private final Name name;

    public RacingCar(final Name name) {
        this.name = name;
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            location++;
        }
    }

    public String generateStatus() {
        return String.join(STATUS_DELIMITER, name.getName(), MOVEMENT_INDICATOR.repeat(location));
    }

    public int getLocation() {
        return location;
    }
}
