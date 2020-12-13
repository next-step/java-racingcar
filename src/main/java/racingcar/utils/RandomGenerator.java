package racingcar.utils;

import racingcar.domain.MoveStrategy;

import java.util.Random;

public class RandomGenerator implements MoveStrategy {
    private static final int RANDOM_MAX = 10;
    private static final int MOVE_CONDITION = 4;

    private final Random random = new Random();

    private int getRandom() {
        return random.nextInt(RANDOM_MAX);
    }

    @Override
    public boolean isMovable() {
        return getRandom() >= MOVE_CONDITION;
    }
}
