package study.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();
    private static final int MAX_RANDOM_VALUE = 10;

    private RandomUtils() { //인스턴스화 방지
    }
    public static int getRandomNumber() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}
