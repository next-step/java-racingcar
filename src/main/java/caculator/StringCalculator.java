package caculator;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PREFIX = Pattern.compile("^//");

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        return new PositiveOrZeros(split(input)).sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        if (!hasCustomDelimiter(input)) {
            return input.split(DEFAULT_DELIMITER_PATTERN);
        }

        String delimiterPattern = buildCustomDelimiterPattern(input);
        String numbersPart = extractNumbersPart(input);
        return numbersPart.split(delimiterPattern);
    }

    private static boolean hasCustomDelimiter(String input) {
        return CUSTOM_DELIMITER_PREFIX.matcher(input).find();
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
}
