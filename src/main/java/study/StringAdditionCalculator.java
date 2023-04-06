package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_INPUT_PATTERN_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if(isNullOrEmpty(input)) {
            return 0;
        }

        String[] operands = operandsOf(input);
        return sumOf(operands);
    }

    private static String[] operandsOf(String input) {
        if(isCustomDelimiterInput(input)) {
            return splitByCustomDelimiter(input);
        }

        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private static String[] splitByCustomDelimiter(String input) {
        Matcher matcher = matcherOf(input);
        matcher.find();

        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    private static boolean isCustomDelimiterInput(String input) {
        return matcherOf(input).matches();
    }

    private static Matcher matcherOf(String input) {
        return Pattern.compile(CUSTOM_DELIMITER_INPUT_PATTERN_REGEX).matcher(input);
    }

    private static int sumOf(String[] operands) {
        return Arrays.stream(operands)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
