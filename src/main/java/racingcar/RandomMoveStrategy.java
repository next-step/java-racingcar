package racingcar;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int MOVE_BOUND = 4;

    private final Random random;

    public RandomMoveStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean isMovable() {
        return this.getRandomNumber(random) >= MOVE_BOUND;
    }

    private int getRandomNumber(Random random) {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
