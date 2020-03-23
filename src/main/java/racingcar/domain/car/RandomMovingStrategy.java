package racingcar.domain.car;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVABLE_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return new Random().nextInt(RANDOM_BOUND) >= MOVABLE_NUMBER;
    }
}
