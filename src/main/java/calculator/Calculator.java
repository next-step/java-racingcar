package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final int ZERO = 0;
    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final String POSITIVE_NUMBER = "[0-9]";
    public static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (isEmpty(input)) {
            return ZERO;
        }

        return sum(toPositiveNumbers(split(input)));
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER.matcher(input);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }

        return input.split(DEFAULT_DELIMITER);
    }

    private static int[] toPositiveNumbers(String[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            result[i] = toPositiveNumber(numbers[i]);
        }

        return result;
    }

    private static int toPositiveNumber(String number) {
        if (!number.matches(POSITIVE_NUMBER)) {
            throw new RuntimeException(number + "는 양수가 아닙니다.");
        }

        return Integer.parseInt(number);
    }

    private static int sum(int[] numbers) {
        int result = ZERO;

        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
