package com.next.step.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int NULL_EMPTY_RETURN_VALUE = 0;

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final String DEFAULT_DELIMITER = "[,:]";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return NULL_EMPTY_RETURN_VALUE;
        }

        return addSplitInput(splitInput(input));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] splitInput(String input) {
        Matcher matchedValue = CUSTOM_PATTERN.matcher(input);
        if (isMatched(matchedValue)) {
            return extractSplitInput(matchedValue);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static boolean isMatched(Matcher matchedValue) {
        return matchedValue.find();
    }

    private static String[] extractSplitInput(Matcher matchedValue) {
        String customDelimiter = matchedValue.group(1);
        return matchedValue.group(2).split(customDelimiter);
    }

    private static int addSplitInput(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .mapToInt(Integer::parseInt)
                .peek(StringAddCalculator::validateNegativeValue)
                .sum();
    }

    private static void validateNegativeValue(Integer stringToNumber) {
        if (stringToNumber < 0) {
            throw new RuntimeException();
        }
    }
}
