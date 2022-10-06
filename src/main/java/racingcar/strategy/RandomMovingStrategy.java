package racingcar.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final Random random = new Random();
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_MIN_NUM = 4;

    @Override
    public boolean isMovable() {
        return makeRandomNumber() >= MOVE_MIN_NUM;
    }

    private int makeRandomNumber() {
        return random.nextInt(RANDOM_BOUND);
    }
}
