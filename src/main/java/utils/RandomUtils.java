package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static final RandomUtils INSTANCE = new RandomUtils();

    private RandomUtils() {}

    public static RandomUtils getInstance() {
        return INSTANCE;
    }

    public int random(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("최소값이 최대값보다 클 수 없습니다.");
        }

        return ThreadLocalRandom.current()
            .nextInt(min, max + 1);
    }

}
