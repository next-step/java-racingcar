package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = "[:,]";
    public static final String PREFIX_CUSTOM_DELIMITER = "//";
    public static final String SUFFIX_CUSTOM_DELIMITER = "\n";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }
        int[] numbers = toInts(expression);
        return sum(numbers);
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static int[] toInts(String expression) {
        String[] strNumbers = split(expression);
        return Arrays.stream(strNumbers)
            .mapToInt(StringAddCalculator::tryParseInt)
            .toArray();
    }

    private static String[] split(String expression) {
        String delimiter = extractDelimiter(expression);
        String cleanExpression = removeDelimiter(expression);

        return cleanExpression.split(delimiter);
    }

    private static String removeDelimiter(String expression) {
        if (hasCustomDelimiter(expression)) {
            return expression.substring(expression.indexOf(SUFFIX_CUSTOM_DELIMITER) + SUFFIX_CUSTOM_DELIMITER.length());
        }
        return expression;
    }

    private static String extractDelimiter(String expression) {
        if (hasCustomDelimiter(expression)) {
            return expression.substring(
                PREFIX_CUSTOM_DELIMITER.length(),
                expression.indexOf(SUFFIX_CUSTOM_DELIMITER)
            );
        }
        return DEFAULT_DELIMITER;
    }

    private static boolean hasCustomDelimiter(String expression) {
        return expression.startsWith(PREFIX_CUSTOM_DELIMITER)
            && expression.contains(SUFFIX_CUSTOM_DELIMITER);
    }

    private static int tryParseInt(String strNumber) {
        int number;
        number = Integer.parseInt(strNumber);
        assertPositive(number);
        return number;
    }

    private static void assertPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다");
        }
    }
}
