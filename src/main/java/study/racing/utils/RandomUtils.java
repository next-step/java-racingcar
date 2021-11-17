package study.racing.utils;

import java.util.Random;

public final class RandomUtils {

    private static final Random random = new Random();
    private static final int LIMIT_RANGE_CRITERIA = 0;
    private static final String LIMIT_RANGE_MUST_BE_POSITIVE = "limitRange must be positive";

    private RandomUtils() {
    }

    public static int nextInt(int limitRange) {
        validateOrThrow(limitRange);
        return random.nextInt(limitRange);
    }

    private static void validateOrThrow(int limitRange) {
        if (limitRange < LIMIT_RANGE_CRITERIA) {
            throw new RuntimeException(LIMIT_RANGE_MUST_BE_POSITIVE);
        }
    }
}
