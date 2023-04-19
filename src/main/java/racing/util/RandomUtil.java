package racing.util;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();
    public static final int BOUND = 10;

    public static int getRandomValue() {
        return random.nextInt(BOUND);
    }
}
