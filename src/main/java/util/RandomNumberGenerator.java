package util;

import java.util.Random;

public class RandomNumberGenerator implements RandomGenerator {
    private static Random random = new Random();
    private static final int MAX_BOUND = 10;

    @Override
    public int generate() {
        return random.nextInt(MAX_BOUND);
    }
}
