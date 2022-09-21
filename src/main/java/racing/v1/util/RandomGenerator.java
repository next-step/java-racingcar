package racing.v1.util;

import java.util.Random;

public class RandomGenerator {
    static private Random random = new Random();
    final static private int MAX = 10;
    public static int generate() {
        return random.nextInt(MAX);
    }
}
