package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_RANGE = 10;
    private static final int MIN_MOVE_BOUNDARY = 4;

    private Random random;

    public RandomMoveStrategy() {
        this.random = new Random();
    }

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_RANGE) >= MIN_MOVE_BOUNDARY;
    }
}
