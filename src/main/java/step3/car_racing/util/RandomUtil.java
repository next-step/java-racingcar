package step3.car_racing.util;

import java.util.Random;

public class RandomUtil {

    private static final Integer RANDOM_RANGE = 10;
    private static final Integer STANDARD_VALUE = 4;
    private static final Random random = new Random();

    private RandomUtil() {
        // 인스턴스화 방지
        throw new AssertionError();
    }

    public static Boolean isForward() {
        return random.nextInt(RANDOM_RANGE) > STANDARD_VALUE;
    }
}
