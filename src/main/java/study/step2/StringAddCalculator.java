package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (!hasText(input)) {
            return 0;
        }
        return sum(toInts(split(input)));
    }

    private static boolean hasText(String input) {
        return input != null && !input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PREFIX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = parseIntOrThrow(values[i]);
        }
        return numbers;
    }

    private static int parseIntOrThrow(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
