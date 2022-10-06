package racingcar;

import java.util.Random;

public class Car {
    private static final int RANDOM_BOUND = 10;
    private static final int RACE_THRESHOLD = 4;
    private static final Random random = new Random();

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public void race() {
        if (random.nextInt(RANDOM_BOUND) >= RACE_THRESHOLD) {
            distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
