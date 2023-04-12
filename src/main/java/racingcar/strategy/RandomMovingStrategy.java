package racingcar.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int TOTAL_BOUND = 10;
    private static final int SUCCESS_BOUND = 4;
    private final Random random;

    public RandomMovingStrategy() {
        this.random = new Random();
    }

    public RandomMovingStrategy(Random random) {
        this.random = random;
    }

    @Override
    public int movement() {
        if (random.nextInt(TOTAL_BOUND) >= SUCCESS_BOUND) {
            return 1;
        }
        return 0;
    }
}
