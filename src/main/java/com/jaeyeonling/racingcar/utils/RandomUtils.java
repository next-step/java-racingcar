package com.jaeyeonling.racingcar.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtils {

    private static final int MINIMUM_BOUND = 1;
    private static final Random random = ThreadLocalRandom.current();

    private RandomUtils() { }

    public static int getIntWithBound(final int bound) {
        if (bound < MINIMUM_BOUND) {
            throw new IllegalArgumentException("bound 값은 양수만 가능합니다.");
        }

        return random.nextInt(bound);
    }
}
