package step5;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    public static final int BOUND = 10;
    public static final int THRESHOLD = 4;
    private final Random random;

    public RandomMovingStrategy(Random random) {
        this.random = random;
    }

    @Override
    public boolean movable() {
        return random.nextInt(BOUND) >= THRESHOLD;
    }
}
