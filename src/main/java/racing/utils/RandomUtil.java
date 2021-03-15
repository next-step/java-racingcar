package racing.utils;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
