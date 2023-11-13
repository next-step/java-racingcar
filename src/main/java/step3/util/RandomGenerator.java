package step3.util;

import java.util.Random;

public class RandomGenerator {
    private static final int BOUND = 10;
    private static final Random random = new Random();

    public static int makeRandomInt() {
        return random.nextInt(BOUND);
    }
}
