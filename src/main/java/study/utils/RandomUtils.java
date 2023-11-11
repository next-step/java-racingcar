package study.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    private RandomUtils() { //인스턴스화 방지
    }

    private static int getRandomNumber() {
        return random.nextInt(10);
    }

    public static int getRandomNumberZeroToNine() {
        return random.nextInt(10);
    }
}
