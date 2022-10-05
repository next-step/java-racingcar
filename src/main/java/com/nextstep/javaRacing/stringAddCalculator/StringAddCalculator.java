package com.nextstep.javaRacing.stringAddCalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return sum(parseUnsignedInts(split(input)));
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String valuePattern = matcher.group(2);
            return valuePattern.split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private static int[] parseUnsignedInts(String[] numericStrings) {
        return Arrays.stream(numericStrings)
                .mapToInt(StringAddCalculator::parseUnsignedInt)
                .toArray();
    }

    private static int parseUnsignedInt(String numericString) {
        try {
            return Integer.parseUnsignedInt(numericString);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("input value should be positive number : " + numericString);
        }
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }
}
