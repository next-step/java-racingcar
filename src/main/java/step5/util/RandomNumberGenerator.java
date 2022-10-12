package step5.util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final Random random = new Random();

    public static int generate() {
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }
}
