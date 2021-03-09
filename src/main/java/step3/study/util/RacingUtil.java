package step3.study.util;

import java.util.Random;

public class RacingUtil {
    private static int RANDOM_BOUND = 10;

    public static int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }
}
