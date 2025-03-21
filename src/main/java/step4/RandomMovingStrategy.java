package step4;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int BOUND = 10;
    private static final int THRESHOLD = 4;

    private final Random random;

    public RandomMovingStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean canMove() {
        return random.nextInt(BOUND) >= THRESHOLD;
    }
}
