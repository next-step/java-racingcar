package step3.model;

import java.util.Random;

import static step3.constant.MagicNumber.*;

public class Car {
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
