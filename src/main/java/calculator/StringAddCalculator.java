package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static String SEPARATOR = ",|:";
    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            return customSplit(matcher);
        }
        return basicSplit(text);
    }

    private static String[] customSplit(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    private static String[] basicSplit(String text) {
        return text.split(SEPARATOR);
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
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = positive(tokens[i]);
        }
        return numbers;
    }

    private static int positive(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new RuntimeException("음수 값이 들어올 수 없습니다.");
        }
        return number;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}
