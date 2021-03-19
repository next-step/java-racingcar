package racing.utils;

import java.util.Random;

public class RandomUtil {
    private static final int CAR_MAX_VALUE = 9;

    private static final Random random = new Random();

    public static int carRandomValue() {
        return random.nextInt(CAR_MAX_VALUE);
    }
}
