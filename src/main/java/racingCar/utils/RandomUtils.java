package racingCar.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static int random(int range) {
        return random.nextInt(range);
    }
}
