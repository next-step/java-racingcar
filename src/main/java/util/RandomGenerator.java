package util;

import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_BOUNDARY = 10;
    private static final Random random = new Random();

    public static int generateNumberBetweenZeroToNine() {
        return random.nextInt(RANDOM_BOUNDARY);
    }
}
