package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_SEPARATOR = ",|:";
    public static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";

    public static int calculate(final String text) {
        if(isBlank(text)) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static String[] split(final String text) {
        final Matcher m = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        if (m.find()) {
            final String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_SEPARATOR);
    }

    private static int sum(final int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static int[] toInts(final String[] values) {
        final int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int number = toPositive(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int toPositive(final String value) {
        int number = Integer.parseInt(value);
        if(number < 0) {
            throw new RuntimeException("음수 값이 들어올 수 없습니다.");
        }
        return number;
    }

    private static boolean isBlank(final String value) {
        return value == null || value.isBlank();
    }
}
