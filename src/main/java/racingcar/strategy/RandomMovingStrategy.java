package racingcar.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 10;
    private static final int MOVABLE_MIN_RANDOM_VALUE = 4;

    @Override
    public boolean isMove() {
        return RANDOM.nextInt(RANDOM_BOUND) >= MOVABLE_MIN_RANDOM_VALUE;
    }
}
