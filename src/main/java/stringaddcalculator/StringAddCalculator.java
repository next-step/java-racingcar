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

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if (matcher.find()) {
            return splitAndSum(matcher.group(EXPRESSION_MATCH), matcher.group(CUSTOM_DELIMITER_MATCH));
        }
        return splitAndSum(expression, DEFAULT_DELIMITER);
    }

    private static int splitAndSum(String expression, String delimiter) {
        String[] stringNumbers = expression.split(delimiter);
        checkIfPositiveInteger(stringNumbers);
        int[] numbers = toIntArray(stringNumbers);
        return sum(numbers);
    }

    private static void checkIfPositiveInteger(String[] stringNumbers) {
        Arrays.stream(stringNumbers)
                .filter(strNum -> !isInteger(strNum) || !isPositive(strNum))
                .findAny()
                .ifPresent(strNum -> {
                    throw new IllegalArgumentException("Invalid operand provided. operand = " + strNum);
                });
    }

    private static boolean isInteger(String strNum) {
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

    private static boolean isPositive(String strNum) {
        return Integer.parseInt(strNum) > 0;
    }

    private static int[] toIntArray(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }
}
