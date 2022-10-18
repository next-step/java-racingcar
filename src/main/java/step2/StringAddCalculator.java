package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String PATTERN = "//(.)\n(.*)";
    public static final String SEPARATOR = "[,:]";

    public static int splitAndSum(String input) {
        if (isBlank(input)) return 0;
        return getSum(toInts(getSplit(input)));
    }

    private static String[] getSplit(String input) {
        String[] tokens;
        Matcher m = Pattern.compile(PATTERN).matcher(input);
        if (m.find()) {
            String customSplitDelimiter = m.group(1);
            tokens = m.group(2).split(customSplitDelimiter);
        } else {
            tokens = input.split(SEPARATOR);
        }
        return tokens;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static int getSum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] toInts(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = toPositive(tokens[i]);
        }
        return numbers;
    }

    private static int toPositive(String token) {
        int number = Integer.parseInt(token);
        if (number < 0) throw new IllegalArgumentException("잘못된 토큰입니다.");
        return number;
    }
}
