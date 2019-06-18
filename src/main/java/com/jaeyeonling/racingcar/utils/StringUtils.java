package com.jaeyeonling.racingcar.utils;

import com.jaeyeonling.exception.RepeatCountNegativeException;

import java.util.Objects;

public final class StringUtils {

    public static final String NEW_LINE = "\n";

    private StringUtils() { }

    public static String repeat(final String target,
                                final int repeatCount) {
        if (repeatCount < RepeatCountNegativeException.MINIMUM_REPEAT_COUNT) {
            throw new RepeatCountNegativeException(repeatCount);
        }

        return target.repeat(repeatCount);
    }

    public static boolean isEmpty(final String target) {
        return !Objects.isNull(target) && target.isEmpty();
    }
}