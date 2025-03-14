package carracing;

import java.util.Random;

public class RandomNumberGenerator {
    public static final int RANDOM_UPPER_BOUND = 10;
    private static Random random;

    public RandomNumberGenerator(int seed) {
        random = new Random(seed);
    }

    public int generateNumber() {
        return random.nextInt(RANDOM_UPPER_BOUND);
    }
}
