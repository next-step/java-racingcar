package study.racinggame.util;

import java.util.Random;

public class RandomUtil {
    final static Random RANDOM = new Random();
    final static int RANDOM_BOUND = 10;

    public static int generateNumber() {
        return RANDOM.nextInt(RANDOM_BOUND);
    }
}
