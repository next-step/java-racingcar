package caculator;

import java.util.Arrays;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        return sum(toPositive(parse(input)));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] parse(String input) {
        if (!hasCustomDelimiter(input)) {
            return input.split(DEFAULT_DELIMITER_PATTERN);
        }

        String delimiterPattern = buildCustomDelimiterPattern(input);
        String numbersPart = extractNumbersPart(input);
        return numbersPart.split(delimiterPattern);
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private static String buildCustomDelimiterPattern(String input) {
        String customDelimiter = extractCustomDelimiter(input);
        return addCustomDelimiter(customDelimiter);
    }

    private static String extractCustomDelimiter(String input) {
        return input.substring(2, getDelimiterEndPosition(input));
    }

    private static String addCustomDelimiter(String customDelimiter) {
        return DEFAULT_DELIMITER_PATTERN + "|" + customDelimiter;
    }

    private static String extractNumbersPart(String input) {
        return input.substring(getDelimiterEndPosition(input) + 1);
    }

    private static int getDelimiterEndPosition(String input) {
        return input.indexOf("\n");
    }

    private static int[] toPositive(String[] tokens) {
        return Tokens.from(tokens).toPositive();
    }

    private static int sum(int[] numbers) {
        return Numbers.from(numbers).sum();
    }
}
