package calculator;

import java.util.regex.Matcher;

import static java.util.regex.Pattern.*;

public class StringAddCalculator {

    public static final String SEPARATOR = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(splitCustomSeparatorOrDefault(text)));
    }
    private static String[] splitCustomSeparatorOrDefault(String text) {
        String[] result = splitCustomSeparator(text);
        if (result != null) return result;
        return text.split(SEPARATOR);
    }

    private static String[] splitCustomSeparator(String text) {
        Matcher matcher = compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return null;
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

    private static Positive sum(Positive[] numbers) {
        Positive result = new Positive(0);

        for (Positive number : numbers) {
            result = result.plus(number);

        }
        return result;
    }
    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private static int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수 값이 들어올 수 없습니다.");
        }
        return number;
    }
}
