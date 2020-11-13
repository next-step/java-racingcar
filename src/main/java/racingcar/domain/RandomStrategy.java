package racingcar.domain;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {
    private final static int RANDOM_MAX_VALUE = 10;
    private final static int NEED_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return new Random().nextInt(RANDOM_MAX_VALUE) >= NEED_NUMBER;
    }
}
