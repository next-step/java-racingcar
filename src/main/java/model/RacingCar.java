package model;

public class RacingCar {

    private static final int MOVE_THRESHOLD = 4;
    private static final String MOVEMENT_INDICATOR = "-";
    private static final String STATUS_DELIMITER = " : ";

    private final Location location;
    private final Name name;

    public RacingCar(final Name name) {
        location = new Location(0);
        this.name = name;
    }

    public RacingCar(final Location location, final Name name) {
        this.location = location;
        this.name = name;
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            location.increase();
        }
    }

    public String generateStatus() {
        return String.join(STATUS_DELIMITER, name.getName(), MOVEMENT_INDICATOR.repeat(location.getValue()));
    }

    public Location getLocation() {
        return location;
    }
}
