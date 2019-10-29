package com.seok.racing.utils;

import java.util.Collections;

public class StringUtils {

    private final static String SEPARATOR = ",";
    private final static String DELIMITER = "";

    private StringUtils() {
    }

    public static String[] split(String text, String separator) {
        return text.split(separator);
    }

    public static String[] split(String text) {
        return text.split(SEPARATOR);
    }

    public static String repeat(String str, int count) {
        return String.join(DELIMITER, Collections.nCopies(count, str));
    }

}
