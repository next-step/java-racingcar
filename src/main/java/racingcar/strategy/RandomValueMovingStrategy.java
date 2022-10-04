package racingcar.strategy;

import java.util.Random;

public class RandomValueMovingStrategy implements MovingStrategy {

    private static final int MOVING_THRESHOLD_VALUE = 4;
    private static final int RANDOM_MAX_BOUND_VALUE = 10;
    private static final Random RANDOM = new Random();

    @Override
    public boolean isMovable() {
        return makeRandomValue() >= MOVING_THRESHOLD_VALUE;
    }

    private int makeRandomValue() {
        return RANDOM.nextInt(RANDOM_MAX_BOUND_VALUE);
    }
}
