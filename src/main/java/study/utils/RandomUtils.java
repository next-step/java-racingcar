package study.utils;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    private RandomUtils() { //인스턴스화 방지
    }

    public static int getRandomBetween0To9Number() {
        return random.nextInt(10);
    }
}
