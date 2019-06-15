package com.jaeyeonling.racingcar.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtils {

    private static final Random random = ThreadLocalRandom.current();

    private RandomUtils() { }

    public static int getIntWithBound(final int bound) {
        return random.nextInt(bound);
    }
}
