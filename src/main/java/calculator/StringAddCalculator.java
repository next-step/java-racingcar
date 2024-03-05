package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(final String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        final Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            final String customDelimiter = m.group(1);
            final String[] tokens = m.group(2).split(customDelimiter);
            return calculateSum(tokens);
        }

        final String[] strings = s.split(",|:");
        return calculateSum(strings);
    }

    private static int calculateSum(final String[] strings) {
        int sum = 0;
        for (final String value : strings) {
            final int number = convertStringToInt(value);
            validatePositive(number);
            sum += number;
        }
        return sum;
    }

    private static int convertStringToInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static void validatePositive(final int value) {
        if (value < 0) {
            throw new RuntimeException();
        }
    }
}
