package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isBlankText(text)) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values = m.group(2).split(customDelimiter);
            return sum(values);
        }

        String[] values = text.split(",|:");
        return sum(values);
    }

    private static boolean isBlankText(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(String[] values) {
        int[] numbers = toNumbers(values);
        int sum = 0;

        for (int number : numbers) {
            sum += isPositiveNumber(number);
        }
        return sum;
    }

    private static int isPositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

    private static int[] toNumbers(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }
}