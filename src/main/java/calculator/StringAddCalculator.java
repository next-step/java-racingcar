package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final int CUSTOM_DELIMITER_GROUP = 1;
    public static final int TEXT_GROUP = 2;
    public static final int BLANK_STRING_SUM = 0;

    private StringAddCalculator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated.");
    }

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return BLANK_STRING_SUM;
        }
        String[] split = split(text);
        int[] intArray = toIntArray(split);
        return sum(intArray);
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] toIntArray(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String values) {
        int number = Integer.parseInt(values);
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
        }
        return number;
    }

    private static String[] split(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
            return m.group(TEXT_GROUP).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
