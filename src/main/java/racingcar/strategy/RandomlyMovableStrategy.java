package racingcar.strategy;

import java.util.Random;

public class RandomlyMovableStrategy implements MovableStrategy {
    public static final int VALUE_RANGE = 10;
    private static final int MOVABLE_MINIMUM_VALUE = 4;

    private final Random random;

    public RandomlyMovableStrategy() {
        random = new Random();
    }

    private RandomlyMovableStrategy(Random random) {
        this.random = random;
    }

    public static RandomlyMovableStrategy initRandomSeed(Random random) {
        return new RandomlyMovableStrategy(random);
    }

    @Override
    public boolean isMovable() {
        if (MOVABLE_MINIMUM_VALUE <= random.nextInt(VALUE_RANGE)) {
            return true;
        }
        return false;
    }
}
