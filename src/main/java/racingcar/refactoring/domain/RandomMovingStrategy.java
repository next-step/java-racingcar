package racingcar.refactoring.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int RANDOM_THRESHOLD = 4;
    private static final int MAX_BOUND = 8;
    private static final Random random = new Random();

    @Override
    public boolean movable() {
        return random.nextInt(MAX_BOUND) + 1 >= RANDOM_THRESHOLD;
    }
}
