package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return sum(toInts(tokens));
        }

        String[] tokens = text.split(",|:");
        return sum(toInts(tokens));
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = toInt(tokens[i]);
        }
        return numbers;
    }

    private static int toInt(String token) {
        int number = Integer.parseInt(token);
        if (number < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }

        return number;
    }
}
