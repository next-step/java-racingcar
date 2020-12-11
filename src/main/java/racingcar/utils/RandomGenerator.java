package racingcar.utils;

import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_MAX = 10;
    private static final int MOVE_CONDITION = 4;
    private final Random random = new Random();

    private int getRandom() {
        return random.nextInt(RANDOM_MAX);
    }

    public boolean isMovable() {
        return getRandom() <= MOVE_CONDITION;
    }
}
