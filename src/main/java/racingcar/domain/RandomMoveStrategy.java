package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int UPPER_BOUND = 10;

    private static final int BOUNDARY = 4;

    private static final int FORWARD = 1;

    private static final int STOP = 0;

    private static final Random random = new Random();

    @Override
    public int amount() {
        if (random.nextInt(UPPER_BOUND) < BOUNDARY) {
            return STOP;
        }
        return FORWARD;
    }
}
