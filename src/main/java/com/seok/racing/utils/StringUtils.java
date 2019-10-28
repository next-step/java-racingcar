package com.seok.racing.utils;

public class StringUtils {

    private final static String SEPARATOR = ",";

    private StringUtils () {}

    public static String [] split(String text, String separator) {
        return text.split(separator);
    }

    public static String [] split(String text) {
        return text.split(SEPARATOR);
    }

}
