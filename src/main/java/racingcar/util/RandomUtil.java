package racingcar.util;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();

    public static int getRandomIntBetweenZeroToNine() {
        return random.nextInt(10);
    }
}
