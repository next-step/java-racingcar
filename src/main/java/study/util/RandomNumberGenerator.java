package study.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();
    private static final int MAX_RANDOM_VALUE = 10;

    private RandomNumberGenerator() { //인스턴스화 방지
    }
    public static int getRandomNumber() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}
