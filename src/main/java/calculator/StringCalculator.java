package calculator;

public class StringCalculator {

    private static final String DELIMITER = " ";

    static int calculator(String text) {

        String[] values = text.split(DELIMITER);

        String firstValue = values[0];
        int totalSum = setInitValue(firstValue);

        for (int index = 1; index < values.length; index += 2) {
            String operator = values[index];
            int nextSumValue = Integer.parseInt(values[index + 1]);
            totalSum = executeCalculation(operator, totalSum, nextSumValue);
        }

        return totalSum;
    }

    private static int setInitValue(String values) {
        return Integer.parseInt(values);
    }

    private static int executeCalculation(String operator, int i, int j) {
        if ("+".equals(operator)) {
            return addition(i, j);
        }
        if ("-".equals(operator)) {
            return subtraction(i, j);
        }
        if ("*".equals(operator)) {
            return multiplication(i, j);
        }
        if ("/".equals(operator)) {
            return division(i, j);
        }
        throw new IllegalArgumentException();
    }

    private static int division(int i, int j) {
        return i / j;
    }

    private static int multiplication(int i, int j) {
        return i * j;
    }

    private static int subtraction(int i, int j) {
        return i - j;
    }

    private static int addition(int i, int j) {
        return i + j;
    }

}
