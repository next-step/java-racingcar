package racing.util;

import java.util.Random;

public class RandomGenerator {
    private static Random random = new Random();

    public static int generate() {
        return random.nextInt(10);
    }
}
