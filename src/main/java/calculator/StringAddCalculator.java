package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String SEPARATOR = ",|:";
    public static final String CUSTOM_SEPARATOR_REGEX_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX_PATTERN).matcher(text);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String[] values = matcher.group(2).split(customSeparator);
            return sum(toInts(values));
        }

        String[] values = text.split(SEPARATOR);
        return sum(toInts(values));
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException();
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
