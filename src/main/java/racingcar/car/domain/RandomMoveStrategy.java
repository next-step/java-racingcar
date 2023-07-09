package racingcar.car.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVE_THRESHOLD = 4;
    public static final int RANDOM_BOUND = 10;
    private static final Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_BOUND) >= MOVE_THRESHOLD;
    }
}
