package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String SEPARATOR = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)){
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static String[] split(String text) {
        String[] tokens = customSplit(text);
        if (tokens != null) {
            return tokens;
        }
        return text.split(SEPARATOR);
    }

    private static String[] customSplit(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        return null;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static Positive sum(Positive[] numbers) {
        Positive result = new Positive(0);
        for (Positive number : numbers) {
            result = result.plus(number);
        }
        return result;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i =0; i< values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private static int toPositive(String value) {
        int number =  Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수 값 X");
        }
        return number;
    }
}
