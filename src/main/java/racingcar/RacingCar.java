package racingcar;

import java.util.Random;

public class RacingCar {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 10;
    private static final int MOVABLE_MIN_RANDOM_VALUE = 4;

    private int distance = 0;

    public void move() {
        if (this.isMovable()) {
            distance++;
        }
    }

    private boolean isMovable() {
        return RANDOM.nextInt(RANDOM_BOUND) >= MOVABLE_MIN_RANDOM_VALUE;
    }

    public String getLocationString() {
        return "-".repeat(distance);
    }
}
