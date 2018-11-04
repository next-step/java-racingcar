package calculator;

/**
 * 2 + 3 * 4 / 5
 */
public class CalculatorString {
    public static int calculate(String text) {
        String[] values = text.split(" ");

        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        String operator = values[1];
        int total = calcu(operator, first, second);

        for (int i=4; i<values.length; i += 2) {
            operator = values[i-1];
            second = Integer.parseInt(values[i]);
            total = calcu(operator, total, second);
        }

        return total;
    }

    public static int calcu(String operator, int first, int second) {
        if (operator.equals("+")) {
            return first + second;
        }

        if (operator.equals("-")) {
            return first - second;
        }

        if (operator.equals("*")) {
            return first * second;
        }

        if (operator.equals("/")) {
            return first / second;
        }

        return 0;
    }
}
