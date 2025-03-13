package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String DELIMITER = "[,:]";
    public static final String REGEX = "//(.)\n(.*)";

    public static int calculate(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(REGEX).matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(DELIMITER);
    }

    private static int[] toInts(String[] values) {
        int size = values.length;
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
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

    private static int sum(int[] values) {
        int result = 0;

        for (int value : values) {
            result += value;
        }

        return result;
    }
}
