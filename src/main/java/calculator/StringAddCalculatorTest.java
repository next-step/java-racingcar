package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculatorTest {
    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values = m.group(2).split(customDelimiter);
            return sum(toInts(values));
        }
        String[] values = text.split(",|:");
        return sum(toInts(values));
    }

    private static String[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return values;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("Negative number is not accepted.");
        }
        return number;
    }

    private static int sum(String[] values) {
        int acc = 0;
        for (String value: values) {
            acc += toInt(value);
        }
        return acc;
    }
}
