package racing.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static int generate() {
        return random.nextInt(10);
    }
}
