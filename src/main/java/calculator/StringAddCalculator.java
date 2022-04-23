package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int SUMMED_VALUE_IS_ZERO = 0;
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER = 1;
    private static final int TARGET = 2;

    private StringAddCalculator() {
        throw new AssertionError();
    }

    public static int splitAndSum(String text) {
        if (isBlankText(text)) {
            return SUMMED_VALUE_IS_ZERO;
        }

        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER);
            String[] values = matcher.group(TARGET).split(customDelimiter);
            return sum(values);
        }

        String[] values = text.split(",|:");
        return sum(values);
    }

    private static boolean isBlankText(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(String[] values) {
        int[] numbers = toNumbers(values);
        int sum = 0;

        for (int number : numbers) {
            sum += isPositiveNumber(number);
        }
        return sum;
    }

    private static int isPositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static int[] toNumbers(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }
}