package racing.util;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    public static int randomInt(int bound) {
        return random.nextInt(bound);
    }
}
