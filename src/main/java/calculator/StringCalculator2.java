package calculator;

public class StringCalculator2 {

    static int calculator(String test) {
        String[] values = test.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        String expression = values[1];

        return calculator(first, second, expression);

    }

    private static int calculator(int first, int second, String expression) {
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
