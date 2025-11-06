package caculator;

import java.util.Arrays;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String[] tokens = parseToTokens(input);
        return sumTokens(tokens);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] parseToTokens(String input) {
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

    private static int sumTokens(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(StringCalculator::parsePositiveNumber)
                .sum();
    }

    private static int parsePositiveNumber(String token) {
        int number = Integer.parseInt(token);
        validatePositive(number);
        return number;
    }

    private static void validatePositive(int number) {
        if (isNegative(number)) {
            throw new RuntimeException("음수를 입력할 수 없습니다: " + number);
        }
    }

    private static boolean isNegative(int number) {
        return number < 0;
    }
}
