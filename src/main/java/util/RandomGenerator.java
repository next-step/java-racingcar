package util;

import java.util.Random;

public class RandomGenerator {

    private static final Random RANDOM = new Random();

    public static int getCarRandomInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    private RandomGenerator() {
    }
}
