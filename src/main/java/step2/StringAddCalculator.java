package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringAddCalculator {

    private static String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static String DEFAULT_DELIMITER_REGEX = ",|:";
    private static int CUSTOM_MATCHER_DELIMITER_INDEX = 1;
    private static int CUSTOM_MATCHER_TEXT_INDEX = 2;
    private static int ZERO = 0;

    public static int splitAndSum(String text) {
        if (empty(text)) {
            return ZERO;
        }

        String[] tokens = splitedTokens(text);
        validatePositive(tokens);

        return sum(tokens);
    }

    private static String[] splitedTokens(String text) {
        String delimiter = delimiter(text);
        String target = target(text);

        return target.split(delimiter);
    }

    private static String delimiter(String text) {
        Matcher matcher = customMatcher(text);
        if (matcher.find()) {
            return matcher.group(CUSTOM_MATCHER_DELIMITER_INDEX);
        }

        return DEFAULT_DELIMITER_REGEX;
    }

    private static String target(String text) {
        Matcher matcher = customMatcher(text);
        if (matcher.find()) {
            return matcher.group(CUSTOM_MATCHER_TEXT_INDEX);
        }

        return text;
    }

    private static Matcher customMatcher(String text) {
        return Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
    }

    private static boolean empty(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
            .mapToInt(number -> Integer.parseInt(number))
            .sum();
    }

    private static void validatePositive(String[] numbers) {
        Arrays.stream(numbers)
            .filter(number -> negative(number))
            .findAny()
            .ifPresent(number -> {
                throw new RuntimeException();
            });
    }

    private static boolean negative(String number) {
        return Integer.parseInt(number) < ZERO;
    }

}