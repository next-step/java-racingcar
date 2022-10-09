package step3;

import java.util.Random;

public class Car {

    private static final int MOVABLE_MINIMUM_VALUE = 4;
    private static final int RANDOM_VALUE_RANGE = 10;
    private static final Random randomGenerator = new Random();
    private int distance;

    public Car() {
        distance = 0;
    }

    public void tryOneRound() {
        if (isMovable()) {
            move();
        }
    }

    public void move() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isMovable() {
        return (MOVABLE_MINIMUM_VALUE <= randomGenerator.nextInt(RANDOM_VALUE_RANGE));
    }
}
