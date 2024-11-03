package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMovable() {
        return getRandomNumber() >= MOVE_THRESHOLD;
    }

    private int getRandomNumber() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUND);
    }
}
