package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {


    public static final String REGEX = "[,:]";
    public static final String CUSTOM_REGEX = "//(.)\n(.*)";
    public static final int ZERO = 0;

    public static int sum(String input) {

        if (isBlankOrNull(input)) return ZERO;
        return sumOf(toNumbers(getSplit(input)));
    }

    private static int sumOf(int[] numbers) {
        int sum = ZERO;
        for (int num : numbers) {
            if (isNegative(num)) throw new RuntimeException();
            sum += num;
        }
        return sum;
    }

    private static String[] getSplit(String input) {

        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);// 덧셈 구현
            return tokens;
        }
        return input.split(REGEX);
    }


    private static int[] toNumbers(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = ZERO; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        return numbers;
    }

    private static boolean isNegative(int num) {
        return num < ZERO;
    }



    private static boolean isBlankOrNull(String input) {
        return input == null || input.isBlank();
    }
}
