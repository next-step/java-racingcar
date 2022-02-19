package domain;

import java.util.Collections;

public class Car {

    public static final int INITIAL_DISTANCE = 0;
    public static final String CAR_STATUS_FORMAT = "%s : %s";
    public static final String DISTANCE_FORMAT = "-";

    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = INITIAL_DISTANCE;
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

    public String convertStatus() {
        return String.format(CAR_STATUS_FORMAT, name, convertDistance());
    }

    private String convertDistance() {
        return String.join("", Collections.nCopies(distance, DISTANCE_FORMAT));
    }
}
