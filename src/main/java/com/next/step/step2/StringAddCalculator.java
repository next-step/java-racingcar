package com.next.step.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String NOT_INCLUDE_NEGATIVE = "입력에 음수 값이 포함되면 안됩니다.";

    private static final String NOT_NUMBER_INPUT = "숫자 이외의 값이 입력돼 수정이 필요합니다.";

    private static final int NULL_EMPTY_RETURN_VALUE = 0;

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private static final String IS_NUMBER_REGEX = "[+-]?\\d*(\\.\\d+)?";

    private static final String DEFAULT_DELIMITER = "[,:]";

    private static final int DELIMITER_EXTRACT_NUMBER = 1;

    private static final int INPUT_EXTRACT_NUMBER = 2;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return NULL_EMPTY_RETURN_VALUE;
        }

        return sumSplitNumbers(splitInput(input));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] splitInput(String input) {
        Matcher customPatternMatcher = CUSTOM_PATTERN.matcher(input);
        if (customPatternMatcher.find()) {
            String customDelimiter = customPatternMatcher.group(DELIMITER_EXTRACT_NUMBER);
            return customPatternMatcher.group(INPUT_EXTRACT_NUMBER).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static int sumSplitNumbers(String[] splitNumbers) {
        return Arrays.stream(splitNumbers)
                .peek(StringAddCalculator::validateNumber)
                .mapToInt(Integer::parseInt)
                .peek(StringAddCalculator::validateNegativeValue)
                .sum();
    }

    private static void validateNegativeValue(Integer stringToNumber) {
        if (stringToNumber < 0) {
            throw new RuntimeException(NOT_INCLUDE_NEGATIVE);
        }
    }

    private static void validateNumber(String splitNumber) {
        if (!splitNumber.matches(IS_NUMBER_REGEX)) {
            throw new RuntimeException(NOT_NUMBER_INPUT);
        }
    }
}
