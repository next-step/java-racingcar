package com.jaeyeonling.racingcar.utils;

public final class StringUtils {

    public static final String NEW_LINE = "\n";

    private StringUtils() { }

    public static String repeat(final CharSequence target,
                                final int repeatCount) {
        return String.valueOf(target)
                .repeat(repeatCount);
    }
}
