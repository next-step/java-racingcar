package carracing.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    public static final int RANDOM_UPPER_BOUND = 10;
    private final Random random;

    public RandomNumberGenerator() {
        random = new Random();
    }

    public int generateNumber() {
        return random.nextInt(RANDOM_UPPER_BOUND);
    }
}
