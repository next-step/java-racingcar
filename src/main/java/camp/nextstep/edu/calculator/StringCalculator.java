package camp.nextstep.edu.calculator;

public class StringCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";

    public static int calculate(String expression) {
        if (isEmpty(expression)) {
            return 0;
        }

        String[] values = split(expression);
        if (hasCustomDelimiter(expression)) {
            String customDelimiter = extractCustomDelimiter(expression);
            expression = removeCustomDelimiter(expression);
            values = split(expression, customDelimiter);
        }

        return sum(toInts(values));
    }

    private static String removeCustomDelimiter(String expression) {
        int beginIndex = expression.indexOf('\n') + 1;
        return expression.substring(beginIndex);
    }

    private static boolean hasCustomDelimiter(String expression) {
        return expression.startsWith("\\");
    }

    private static String extractCustomDelimiter(String expression) {
        int beginIndex = 1;
        int endIndex = expression.indexOf('\n');
        return expression.substring(beginIndex, endIndex);
    }

    private static String[] split(String str, String customDelimiter) {
        return str.split(customDelimiter);
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int[] ints = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            ints[i] = Integer.parseInt(values[i]);
        }
        return ints;
    }

    private static String[] split(String str) {
        return str.split(DEFAULT_DELIMITER);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
