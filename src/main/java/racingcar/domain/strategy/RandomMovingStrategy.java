package racingcar.domain.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    public static final int MOVE_CONSTRAINTS = 4;
    private static final int MAX_RANDOM_RANGE = 10;
    private static final MovingStrategy RANDOM_MOVING_STRATEGY = new RandomMovingStrategy();

    private RandomMovingStrategy() {
    }

    public static MovingStrategy getInstance() {
        return RANDOM_MOVING_STRATEGY;
    }

    @Override
    public boolean movable() {
        return new Random().nextInt(MAX_RANDOM_RANGE) >= MOVE_CONSTRAINTS;
    }
}
