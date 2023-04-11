package step3.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomValue {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private RandomValue() {
    }

    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }

}
