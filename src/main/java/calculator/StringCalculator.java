package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        return sum(toInts(split(input)));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(Pattern.quote(customDelimiter) + "|" + DEFAULT_DELIMITER);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static int[] toInts(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = toInt(tokens[i]);
        }
        return numbers;
    }

    private static int toInt(String token) {
        int number = Integer.parseInt(token);
        validateNonNegative(number);
        return number;
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static void validateNonNegative(int num) {
        if (num < 0) {
            throw new RuntimeException("음수는 입력 불가합니다.");
        }
    }
}
