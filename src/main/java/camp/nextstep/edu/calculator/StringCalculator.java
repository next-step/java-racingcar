package camp.nextstep.edu.calculator;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";

    public static int calculate(String expression) {
        if (isEmpty(expression)) {
            return 0;
        }

        int[] numbers = extractNumbers(expression);
        return sum(numbers);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] extractNumbers(String expression) {
        return toInts(extractValues(expression));
    }

    private static int[] toInts(String[] values) {
        int[] ints = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            ints[i] = Integer.parseInt(values[i]);
        }
        return ints;
    }

    private static String[] extractValues(String expression) {
        String delimiter = extractDelimiter(expression);
        expression = removeDelimiter(expression);
        return split(expression, delimiter);
    }

    private static String removeDelimiter(String expression) {
        int beginIndex = expression.indexOf('\n') + 1;
        return expression.substring(beginIndex);
    }

    private static String[] split(String str, String customDelimiter) {
        return str.split(customDelimiter);
    }

    private static String extractDelimiter(String expression) {
        if (!hasCustomDelimiter(expression)) {
            return DEFAULT_DELIMITER;
        }

        int beginIndex = 1;
        int endIndex = expression.indexOf('\n');
        return expression.substring(beginIndex, endIndex);
    }

    private static boolean hasCustomDelimiter(String expression) {
        return expression.startsWith("\\");
    }
}
