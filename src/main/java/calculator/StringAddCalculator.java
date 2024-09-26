package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = "//(.)\n(.*)";
    public static final String CUSTOM_DELIMITER = "[,:]";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toIntArray(split(text)));
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
            throw new RuntimeException();
        }
        return number;
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(DEFAULT_DELIMITER).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(CUSTOM_DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
