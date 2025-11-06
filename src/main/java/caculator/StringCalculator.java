package caculator;

import java.util.Arrays;

public class StringCalculator {

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String delimiterPattern = ",|:";

        if (hasCustomDelimiter(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            delimiterPattern = delimiterPattern + "|" + customDelimiter;
            input = extractNumbersPart(input);
        }

        String[] tokens = input.split(delimiterPattern);

        return Arrays.stream(tokens)
                .mapToInt(StringCalculator::parsePositiveNumber)
                .sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private static String extractCustomDelimiter(String input) {
        return input.substring(2, getDelimiterEndPosition(input));
    }

    private static String extractNumbersPart(String input) {
        return input.substring(getDelimiterEndPosition(input) + 1);
    }

    private static int getDelimiterEndPosition(String input) {
        return input.indexOf("\n");
    }

    private static int parsePositiveNumber(String token) {
        int number = Integer.parseInt(token);
        if (number < 0) {
            throw new RuntimeException("음수를 입력할 수 없습니다: " + number);
        }
        return number;
    }
}
