package step3.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberUtils {
    private static final int RANDOM_BOUND = 10;

    private static final Random random = ThreadLocalRandom.current();

    private RandomNumberUtils(){}

    /**
     * 0 ~ 9 사이의 랜덤한 숫자를 생성한다.
     * @return 0 ~ 9 사이의 랜덤한 숫자
     */
    public static int generate() {
        return random.nextInt(RANDOM_BOUND);
    }
}
