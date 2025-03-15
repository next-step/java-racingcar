package step3.random;

import java.util.Random;

public class DefaultRandomStrategy implements RandomStrategy {
    private static final int MAX_RANDOM_VALUE = 10;
    private final Random random = new Random();
    @Override
    public int generateRandomValue() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}
