package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DEFAULT_RESULT = 0;
    private static final String DEFAULT_DELIMITER = ":|,";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_MATCH = 1;
    private static final int EXPRESSION_MATCH = 2;


    private StringAddCalculator() {
        throw new AssertionError();
    }

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return DEFAULT_RESULT;
        }

        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if (m.find()) {
            return splitAndSum(m.group(EXPRESSION_MATCH), m.group(CUSTOM_DELIMITER_MATCH));
        }
        return splitAndSum(expression, DEFAULT_DELIMITER);
    }

    private static int splitAndSum(String expression, String delimiter) {
        String[] stringNumbers = expression.split(delimiter);
        checkNumber(stringNumbers);
        int[] numbers = toIntArray(stringNumbers);
        checkNegative(numbers);
        return sum(numbers);
    }

    private static int[] toIntArray(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void checkNumber(String[] stringNumbers) {
        Arrays.stream(stringNumbers)
                .filter(strNum -> !isNumeric(strNum))
                .findAny()
                .ifPresent(strNum -> {
                    throw new IllegalArgumentException("can't be parsed to int. string = " + strNum);
                });
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static void checkNegative(int[] numbers) {
        Arrays.stream(numbers)
                .filter(n -> n < 0)
                .findAny()
                .ifPresent(n -> {
                    throw new IllegalArgumentException("can't process negative number. number = " + n);
                });
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }
}
