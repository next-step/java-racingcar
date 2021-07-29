package racing.model;

import java.util.Random;

public class RandomNumberComparison implements MovingCondition {
    private static final int MOVABLE_MIN_NUMBER = 4;
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    private final Random random;

    public RandomNumberComparison() {
        this.random = new Random();
    }

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_NUMBER_UPPER_BOUND) >= MOVABLE_MIN_NUMBER;
    }
}
