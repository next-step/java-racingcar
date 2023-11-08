package step3.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;

    private RandomNumberGenerator() {}

    public static int makeRandomNumber() {
        return RANDOM.nextInt(BOUND);
    }
}
