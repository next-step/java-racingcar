package calculator;

public class StringCalculator {
    static int calculate(String text) {
        String[] values = text.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        String expression = values[1];

        int result = calculate(first, second, expression);
        
        return result;
    }

    private static int calculate(int first, int second, String expression) {
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
