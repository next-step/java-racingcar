package me.daeho.utils;

public class StringUtils {
    private final static String BLANK = "";

    public static boolean isEmpty(String value) {
        return value == null || BLANK.equals(value);
    }
}
