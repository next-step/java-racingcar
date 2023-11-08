package study.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    private RandomUtils() { //인스턴스화 방지
    }

    public static int getRandomNumberZeroToNine() {
        return random.nextInt(10);
    }
}
