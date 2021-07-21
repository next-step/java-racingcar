package racing;

import java.util.Random;

class RandomNumberGenerator {
    private static final Random RANDOM = new Random();

    private static final int BOUND = 10;

    private RandomNumberGenerator() {
    }

    public static int generate() {
        return RANDOM.nextInt(BOUND);
    }
}
