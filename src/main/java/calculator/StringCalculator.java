package calculator;

public class StringCalculator {

    public static int startCalculate(String expressions) {
        return recursive(expressions);
    }

    private static int recursive(String expressions) {
        String[] values = expressions.split(" ");
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i <= values.length - 1; i += 2) {
            result = calculate(result, values[i], Integer.parseInt(values[i + 1]));
        }
        return result;
    }

    private static int calculate(int first, String expression, int second) {
        if (expression.equals("+")) {
            return first + second;
        }

        if (expression.equals("-")) {
            return first - second;
        }

        if (expression.equals("*")) {
            return first * second;
        }

        if (expression.equals("/")) {
            return first / second;
        }

        return 0;
    }
}

