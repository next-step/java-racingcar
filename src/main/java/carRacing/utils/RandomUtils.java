package carRacing.utils;

import java.util.Random;

public final class RandomUtils {
    private static Random random = new Random();

    public static int nextInt(int end) {
        return random.nextInt(end);
    }
}
