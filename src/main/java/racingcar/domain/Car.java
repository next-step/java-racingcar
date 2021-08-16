package racingcar.domain;

import org.codehaus.plexus.util.StringUtils;

public class Car {
    static final int CRITERION_FOR_MOVING = 4;

    private Location location;
    private String name = "Unknown";

    Car(String name) {
        if (isValidName(name)) {
            this.name = name;
        }

        this.location = new Location(0);
    }

    Car() {
        this("Unknown");
    }

    public int getLocation() {
        return location.getLocation();
    }

    void goForward() {
        location = location.goForward();
    }

    boolean isAbleToMove(int value) throws IllegalArgumentException {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("invalid argument for isAbleToMove : " + value);
        }

        return value >= CRITERION_FOR_MOVING;
    }

    void move(int value) {
        if (isAbleToMove(value)) {
            goForward();
        }
    }

    public String getName() {
        return this.name;
    }

    boolean isValidName(String name) {
        return !(StringUtils.isBlank(name));
    }
}
