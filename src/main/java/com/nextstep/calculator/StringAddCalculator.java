package com.nextstep.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

public class StringAddCalculator {

    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final String TEXT_SEPARATOR = "[,:]";

    private static final String CONTAINS_NEGATIVE_VALUE = "It contains negative value";

    private static final String CONTAINS_INVALID_INTEGER = "It contains invalid character";

    private static final int DELIMITER_INDEX = 1;
    private static final int BODY_INDEX = 2;

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(CUSTOM_SEPARATOR_REGEX);

    public static int splitAndSum(String text) {
        if (isEmptyText(text)) {
            return 0;
        }

        final int[] integers = convertStringIntoArray(text);

        if (containsNegative(integers)) {
            throw new IllegalArgumentException(CONTAINS_NEGATIVE_VALUE);
        }

        return stream(integers).sum();
    }

    private static boolean isEmptyText(String text) {
        return text == null || text.isEmpty();
    }

    private static int[] convertStringIntoArray(String text) {
        Matcher m = CUSTOM_SEPARATOR_PATTERN.matcher(text);
        if (m.find()) {
            return convertStringArrayIntoIntArray(
                    splitTextByDelimiter(m.group(BODY_INDEX),m.group(DELIMITER_INDEX)));
        }
        return convertStringArrayIntoIntArray(
                splitTextByDelimiter(text,TEXT_SEPARATOR));
    }

    private static String[] splitTextByDelimiter(String text, String regex) {
        return text.split(regex);
    }

    private static int[] convertStringArrayIntoIntArray(String[] texts) {
        try {
            return stream(texts)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CONTAINS_INVALID_INTEGER);
        }
    }

    private static boolean containsNegative(int[] integers) {
        return stream(integers).anyMatch(n -> n < 0);
    }
}
