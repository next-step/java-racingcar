package racingcar.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private final Random random = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MOVABLE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_NUMBER_BOUND) >= MOVABLE_NUMBER;
    }
}
