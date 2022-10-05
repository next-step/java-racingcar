package util;

import java.util.Random;

public class RandomNumber {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;

    public static int generate() {
        return RANDOM.nextInt(BOUND);
    }
}
