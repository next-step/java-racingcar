package racing.model;

import java.util.Random;

public class Car {

    private static final int MAX_BOUND = 10;
    private static final int GO_BEHAVIOR_PIVOT = 4;

    private final Random random;
    private int movingDistance = 0;

    public Car() {
        this.random = new Random();
    }

    public Car(Random random) {
        this.random = random;
    }

    public void moveRandom() {
        if (random.nextInt(MAX_BOUND) >= GO_BEHAVIOR_PIVOT) {
            go();
        }
    }

    private void go() {
        movingDistance++;
    }

    public int getMovingDistance() {
        return movingDistance;
    }
}
