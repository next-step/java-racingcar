package racingcar.domain.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MOVE_LOWER_BOUND = 4;

    private static final int RANDOM_UPPER_BOUND = 10;
    private static final Random RANDOM_GENERATOR = new Random();

    @Override
    public boolean canMove() {
        return MOVE_LOWER_BOUND <= RANDOM_GENERATOR.nextInt(RANDOM_UPPER_BOUND);
    }
}
