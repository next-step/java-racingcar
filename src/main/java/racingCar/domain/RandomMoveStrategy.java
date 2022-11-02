package racingCar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final Random random;
    private static final int RANDOM_NUMBER_BOUND = 10;

    public RandomMoveStrategy() {
        this(new Random());
    }

    public RandomMoveStrategy(Random random) {
        this.random = random;
    }

    public boolean canMove() {
        return random.nextInt(RANDOM_NUMBER_BOUND) <= 4;
    }
}
