package racingcar;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private final static int RANDOM_RANGE = 10;
    private final static int CUTLINE = 4;
    private final Random random;

    public RandomMovingStrategy() {
        this.random = new Random();
    }

    public RandomMovingStrategy(long randomSeed) {
        this.random = new Random(randomSeed);
    }

    @Override
    public boolean canMove() {
        return random.nextInt(RANDOM_RANGE) >= CUTLINE;
    }
}
