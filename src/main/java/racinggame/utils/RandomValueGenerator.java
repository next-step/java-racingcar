package racinggame.utils;

import java.util.Random;

public class RandomValueGenerator {
    private static final Random random = new Random();

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
