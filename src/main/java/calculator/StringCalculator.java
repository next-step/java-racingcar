package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DELIMITER = "[,:]";
    private static final String REGEX = "//(.)\n(.*)";

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
        Matcher matcher = Pattern.compile(REGEX).matcher(text);
        final int delimiterGroupNum = 1;
        final int numbersGroupNum = 2;

        if (matcher.find()) {
            String customDelimiter = matcher.group(delimiterGroupNum);
            return matcher.group(numbersGroupNum).split(customDelimiter);
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
            throw new RuntimeException("음수는 불가능합니다.");
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
