package step5.strategy;

import java.util.Random;

public class RandomStrategy implements MovableStrategy {

    private static final int RANDOM_BOUND = 10;

    private static final int THRESHOLD = 4;

    private static final Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_BOUND) >= THRESHOLD;
    }
}
