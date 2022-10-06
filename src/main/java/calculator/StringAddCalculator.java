package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_SEPARATOR_REGEX);

    public static int calculate(final String text) {
        if(isBlank(text)) {
            return 0;
        }
        return sum(toPositive(split(text))).getNumber();
    }

    private static String[] split(final String text) {
        final Matcher m = CUSTOM_PATTERN.matcher(text);
        if (m.find()) {
            final String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_SEPARATOR);
    }

    private static Positive sum(final Positive[] numbers) {
        return Arrays.stream(numbers).reduce(Positive::plus).orElse(Positive.ZERO);
    }

    private static Positive[] toPositive(final String[] values) {
        final Positive[] numbers = new Positive[values.length];
        for (int i = 0; i < values.length; i++) {
            Positive number = new Positive(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static boolean isBlank(final String value) {
        return value == null || value.isBlank();
    }
}
