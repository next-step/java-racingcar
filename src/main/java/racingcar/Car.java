package racingcar;

import java.util.Random;

public class Car {
    private static final int RACE_THRESHOLD = 4;

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public void race(int randomValue) {
        if (randomValue >= RACE_THRESHOLD) {
            distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
