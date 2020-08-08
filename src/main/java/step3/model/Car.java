package step3.model;

import java.util.Random;

public class Car {
    public static final int RANDOM_BOUNDARY = 10;
    public static final int CONDITION_FOR_STEP_FORWARD = 4;
    private int distance;
    private static Random rand = new Random();

    public Car() {
        this.distance = 1;
    }

    public int showDistance() {
        return distance;
    }

    public void increaseDistance() {
        this.distance++;
    }

    public void increaseDistanceWithRandom() {
        if (rand.nextInt(RANDOM_BOUNDARY) >= CONDITION_FOR_STEP_FORWARD) {
            increaseDistance();
        }
    }
}
