package racing;

import java.util.Random;

public class RandomCarMovingStrategy implements CarMovingStrategy {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;

    private final Random randomGenerator;

    public RandomCarMovingStrategy() {
        this(new Random());
    }

    public RandomCarMovingStrategy(Random randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean shouldMove() {
        return randomGenerator.nextInt(RANDOM_BOUND) >= MOVE_THRESHOLD;
    }
}
