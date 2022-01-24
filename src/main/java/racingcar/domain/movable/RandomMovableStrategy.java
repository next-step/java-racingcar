package racingcar.domain.movable;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {

    private final Random RANDOM = new Random();
    private final int CONDITION_MOVE_AVAILABLE = 4;
    private final int bound;

    public RandomMovableStrategy(final int bound) {
        this.bound = bound;
    }

    @Override
    public boolean isMovable() {
        return getRandom(bound) >= CONDITION_MOVE_AVAILABLE;
    }

    private int getRandom(final int bound) {
        return RANDOM.nextInt(bound);
    }
}
