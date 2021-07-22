package racingCar;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {
    private final static int MIN = 0;
    private final static int MAX = 9;

    private RandomUtil() {
    }

    public static int getNumber() {
        return ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
    }
}
