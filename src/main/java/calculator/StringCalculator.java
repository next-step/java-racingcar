package calculator;

public class StringCalculator {
    static int calculate(String text) {
        if (text.equals("") || text.isEmpty()) {
            return -1;
        }

        String[] values = text.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        String expression = values[1];
        int result = calculate(first, second, expression);

        return result;
    }

    private static int calculate(int first, int second, String expression) {
        if ("+".equals(expression)) {
            return Calculator.add(first, second);
        }
        if ("-".equals(expression)) {
            return Calculator.sub(first, second);
        }
        if ("*".equals(expression)) {
            return Calculator.mul(first, second);
        }
        if ("/".equals(expression)) {
            return Calculator.div(first, second);
        }
        return 0;
    }
}
