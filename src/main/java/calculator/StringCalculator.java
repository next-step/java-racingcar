package calculator;

public class StringCalculator {
    static int calculate(String text) {

        if ("".equals(text)) {
            throw new NullPointerException();
        }

        String[] values = text.split(" ");
        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            result = calculate(result, values[i], Integer.parseInt(values[i + 1]));
        }

        return result;
    }

    private static int calculate(int first, String expression, int second) {
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
