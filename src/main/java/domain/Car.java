package domain;

import java.util.Collections;

public class Car {

    public static final int INITIAL_DISTANCE = 0;
    public static final String CAR_STATUS_FORMAT = "%s : %s\n";
    public static final String DISTANCE_FORMAT = "-";
    public static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = INITIAL_DISTANCE;

        validateNameLength(name);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        distance++;
    }

    public String convertCarStatus() {
        return String.format(CAR_STATUS_FORMAT, name, convertDistance());
    }

    private String convertDistance() {
        return String.join("", Collections.nCopies(distance, DISTANCE_FORMAT));
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
