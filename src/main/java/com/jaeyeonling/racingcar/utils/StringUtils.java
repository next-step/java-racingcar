package com.jaeyeonling.racingcar.utils;

public final class StringUtils {

    public static final String NEW_LINE = "\n";

    private static final int REPEAT_START_INDEX = 0;

    private StringUtils() { }

    public static String repeat(final CharSequence target,
                                final int repeatCount) {
        final StringBuilder repeatBuilder = new StringBuilder();
        for (int i = REPEAT_START_INDEX; i < repeatCount; i++) {
            repeatBuilder.append(target);
        }

        return repeatBuilder.toString();
    }
}
