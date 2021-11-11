package racingcar.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int ADVANCE_MIN_NUMBER = 4;
    private static final int RANDOM_MAX_RANGE = 10;
    private final Random random;

    public RandomMovingStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean isMove() {
        return random.nextInt(RANDOM_MAX_RANGE) >= ADVANCE_MIN_NUMBER;
    }
}
