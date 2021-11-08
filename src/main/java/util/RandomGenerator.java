package util;

import java.util.Random;

public class RandomGenerator {
    private static final int RANDOM_BOUNDARY = 10;

    public static int generateNumberBetweenZeroToNine() {
        Random random = new Random();

        return random.nextInt(RANDOM_BOUNDARY);
    }
}
