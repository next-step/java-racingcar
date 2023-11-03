package camp.nextstep.edu.calculator;

public class StringCalculator {

    public static final String DELIMITER = ",";

    public static int calculate(String expression) {
        if (isEmpty(expression)) {
            return 0;
        }
        return sum(toInts(split(expression)));
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

    private static String[] split(String expression) {
        return expression.split(DELIMITER);
    }

    private static boolean isEmpty(String expression) {
        return expression == null || expression.isBlank();
    }
}
