package racingcar.domain;

import java.util.Random;

public class RandomCarMoveStrategy implements CarMoveStrategy {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_BOUND = 4;

    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(RANDOM_BOUND) >= MOVE_BOUND;
    }

}
