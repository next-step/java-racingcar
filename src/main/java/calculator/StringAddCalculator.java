package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    public static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }
        return sum(toNonNegatives(split(text))).value();
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static NonNegative sum(NonNegative[] numbers) {
        NonNegative total = new NonNegative(0);
        for (NonNegative number : numbers) {
            total = number.plus(total);
        }
        return total;
    }

    private static NonNegative[] toNonNegatives(String[] values) {
        NonNegative[] numbers = new NonNegative[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = new NonNegative(values[i]);
        }
        return numbers;
    }
}
