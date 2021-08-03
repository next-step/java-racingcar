package carracing.utils;

import java.util.Random;

public class RandomValueGenerator {

    private static final Random random = new Random();
    private static final int MAX_RANDOM_VALUE = 10;

    private RandomValueGenerator() {
    }

    public static int generateRandom() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }

}
