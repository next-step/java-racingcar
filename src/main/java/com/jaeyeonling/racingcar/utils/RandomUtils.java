package com.jaeyeonling.racingcar.utils;

import com.jaeyeonling.exception.BoundNegativeException;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtils {

    private static final Random random = ThreadLocalRandom.current();

    private RandomUtils() { }

    public static int getIntWithBound(final int bound) {
        if (bound < BoundNegativeException.MINIMUM_BOUND) {
            throw new BoundNegativeException(bound);
        }

        return random.nextInt(bound);
    }
}
