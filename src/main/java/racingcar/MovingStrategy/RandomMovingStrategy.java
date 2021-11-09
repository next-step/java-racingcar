package racingcar.MovingStrategy;

import racingcar.domain.MovingStrategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final RandomMovingStrategy RANDOM_MOVING_STRATEGY = new RandomMovingStrategy();

    private static final Random RANDOM = new Random();
    private static final int MAX_VALUE = 10;

    private RandomMovingStrategy() {
    }

    public static MovingStrategy getInstance() {
        return RANDOM_MOVING_STRATEGY;
    }

    @Override
    public int generateNumber() {
        return RANDOM.nextInt(MAX_VALUE);
    }
}
