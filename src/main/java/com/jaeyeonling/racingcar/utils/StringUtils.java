package com.jaeyeonling.racingcar.utils;

import java.util.Objects;

public final class StringUtils {

    public static final String NEW_LINE = "\n";

    private static final String MINIMUM_REPEAT_ERROR_MESSAGE = "반복 횟수는 %d 미만이 될 수 없습니다. (입력 값: %d)";
    private static final int MINIMUM_REPEAT_COUNT = 0;

    private StringUtils() { }

    public static String repeat(final String target,
                                final int repeatCount) {
        if (repeatCount < MINIMUM_REPEAT_COUNT) {
            throw new IllegalArgumentException(String.format(MINIMUM_REPEAT_ERROR_MESSAGE,
                    MINIMUM_REPEAT_COUNT,
                    repeatCount));
        }

        return target.repeat(repeatCount);
    }

    public static boolean isEmpty(final String target) {
        return !Objects.isNull(target) && target.isEmpty();
    }
}