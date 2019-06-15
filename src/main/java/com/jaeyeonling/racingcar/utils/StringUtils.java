package com.jaeyeonling.racingcar.utils;

public final class StringUtils {

    public static final String NEW_LINE = "\n";
    public static final String NULL_STRING = "\0";

    private StringUtils() { }

    public static String repeat(final CharSequence target,
                                final int repeatCount) {
        return new String(new char[repeatCount]).replace(NULL_STRING, target);
    }
}
