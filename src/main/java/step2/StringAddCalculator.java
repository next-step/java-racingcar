package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern CUSTOM_MATCHER = Pattern.compile(CUSTOM_DELIMITER);
    private static final int DEFAULT_BLANK_VALUE = 0;

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return DEFAULT_BLANK_VALUE;
        }

        Matcher m = CUSTOM_MATCHER.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values= m.group(2).split(customDelimiter);
            return sum(toInts(values));
        }

        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = PositiveNumber.toPositiveNumber(values[i]);
        }
        return numbers;
    }

    private static String[] split(String text) {
        return text.split(DEFAULT_SEPARATOR);
    }
}
