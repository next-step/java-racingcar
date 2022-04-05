package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ":|,";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if (m.find()) {
            return splitAndSum(m.group(2), m.group(1));
        }
        return splitAndSum(expression, DEFAULT_DELIMITER);
    }

    private static int splitAndSum(String expression, String delimiter) {
        String[] numberStrings = split(expression, delimiter);
        int[] numbers = toIntArray(numberStrings);
        checkNegative(numbers);
        return sumIntArray(numbers);
    }

    private static String[] split(String expression, String delimiter) {
        return expression.split(delimiter);
    }

    private static int[] toIntArray(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void checkNegative(int[] numbers) {
        Arrays.stream(numbers)
                .filter(n -> n < 0)
                .findAny()
                .ifPresent(n -> {
                    throw new RuntimeException("can't process negative number. number = " + n);
                });
    }

    private static int sumIntArray(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }
}
