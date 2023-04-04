package com.nextstep.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

public class StringAddCalculator {

    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final String TEXT_SEPARATOR = "[,:]";

    public static int splitAndSum(String text) {
        if(isEmptyText(text)) return 0;

        int [] integers = convertStringIntoArray(text);

        if(containsNegative(integers)) throw new RuntimeException("It has Negative Value");

        return stream(integers).sum();
    }

    private static boolean isEmptyText(String text) {
        return text == null || text.isEmpty();
    }

    private static int[] convertStringIntoArray(String text) {
        Matcher m = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);

        if(m.find()) {
            return stream(m.group(2)
                    .split(m.group(1)))
                    .mapToInt(Integer::parseInt).toArray();
        }

        return stream(text.split(TEXT_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean containsNegative(int [] integers) {
        return stream(integers).anyMatch(n -> n < 0);
    }
}
