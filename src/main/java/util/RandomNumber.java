package util;

import java.util.Random;

public class RandomNumber {
    private static final Random RANDOM = new Random();

    public static int generate(final int bound) {
        return RANDOM.nextInt(bound);
    }
}
