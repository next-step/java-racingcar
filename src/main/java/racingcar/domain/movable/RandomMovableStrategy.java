package racingcar.domain.movable;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {

    private final Random RANDOM = new Random();
    private static final int CONDITION_MOVE_AVAILABLE = 4;
    private static final int DEFAULT_BOUND = 10;

    public RandomMovableStrategy() {
    }

    @Override
    public boolean isMovable() {
        return getRandom(DEFAULT_BOUND) >= CONDITION_MOVE_AVAILABLE;
    }

    private int getRandom(final int bound) {
        return RANDOM.nextInt(bound);
    }
}
