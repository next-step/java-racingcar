package racingcar.domain.strategy;

import java.util.Random;

public class RandomMoving implements MovingStrategy {

    private static final int RANDOM_BOUND = 10;
    private static final int MOVING_DIVISION_POINT = 4;
    private static final Random random = new Random();

    @Override
    public boolean isMoving() {
        if (random.nextInt(RANDOM_BOUND) < MOVING_DIVISION_POINT) {
            return false;
        }
        return true;
    }
}
