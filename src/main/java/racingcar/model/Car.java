package racingcar.model;

import java.util.Random;

public class Car {
    private static final int RACE_THRESHOLD = 4;

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public void race(int value) {
        if (value >= RACE_THRESHOLD) {
            distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
