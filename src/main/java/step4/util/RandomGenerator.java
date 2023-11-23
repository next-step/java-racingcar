package step4.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private static final int BOUND = 10;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static int makeRandomInt() {
        return random.nextInt(BOUND);
    }
}
