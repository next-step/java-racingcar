package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int NO_INPUT_RETURN_VALUE = 0;


    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return NO_INPUT_RETURN_VALUE;
        }
        return sum(toInt(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private static int[] toInt(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
            validate(numbers[i]);
        }
        return numbers;
    }

    private static void validate(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

}
