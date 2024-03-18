package racingcar;

import java.util.Random;

public class RandomUtil {
    private final static Random random = new Random();

    private RandomUtil() {
    }

    public static int randomCount(int number) {
        return random.nextInt(number);
    }
}
