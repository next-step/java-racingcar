package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int NO_VALUE_RESPONSE = 0;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";

    public int splitAndSum(String input) {
            if (input == null || input.isBlank()) {
                return NO_VALUE_RESPONSE;
            }

            if (input.length() == 1) {
                return Integer.parseInt(input);
            }

        int[] numbers = split(input);
        return sum(numbers);
    }

    private int[] split(String input) {
        String[] stringInts = {};
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            stringInts = matcher.group(2).split(customDelimiter);
        } else {
            stringInts = input.split(DEFAULT_DELIMITER_PATTERN);
        }

        return convertStringArrayToIntArray(stringInts);
    }

    private int sum(int[] input) {
        return Arrays.stream(input).sum();
    }

    private int[] convertStringArrayToIntArray(String[] input) {
        return Arrays.stream(input)
                .mapToInt(this::parseInt)
                .map(this::validatePositive)
                .toArray();
    }

    private int parseInt(String value) {
        try {
            int number = Integer.parseInt(value);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다: " + value, e);
        }
    }

    private int validatePositive(int number) {
        if (number < 0) {
            throw new NegativeNumberException("음수값이 입력되었습니다: " + number);
        }

        return number;
    }
}
