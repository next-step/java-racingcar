package utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static int nextInt(int bound) {
        if (bound <= 0) {
            throw new IllegalArgumentException("bound는 양수이어야 합니다.");
        }
        return RANDOM.nextInt(bound);
    }
}
