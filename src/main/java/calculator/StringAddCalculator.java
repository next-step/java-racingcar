package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    final static String PREDEFINED_SEPARATOR = "[,:]";

    final static Pattern DELIMITER_PATTEN= Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            checkNegative(number);
            result += number;
        }
        return result;
    }

    private static void checkNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static String[] split(String text) {
        Matcher m = DELIMITER_PATTEN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] stringNumbers = m.group(2).split(customDelimiter);
            return stringNumbers;
        }
        return text.split(PREDEFINED_SEPARATOR);
    }


}
