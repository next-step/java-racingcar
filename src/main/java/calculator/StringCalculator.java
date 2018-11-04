package calculator;

public class StringCalculator {

    private static String PLUS = "+";
    private static String SUBSTRACTION = "-";
    private static String MULTIPLY = "*";
    private static String DIVIDE = "/";

    private Calculator calculator;

    public StringCalculator() {
        calculator = new Calculator();
    }

    public int calculate(String text) {
        String[] values = text.split(" ");

        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            int second = Integer.parseInt(values[i+1]);
            result = getFirst(values[i], result, second);
        }

        return result;
    }

    private int getFirst(String value, int result, int second) {
        if (value.equals(PLUS)) {
            result = calculator.add(result, second);
        }

        if (value.equals(SUBSTRACTION)) {
            result = calculator.sub(result, second);
        }

        if (value.equals(MULTIPLY)) {
            result = calculator.multiply(result, second);
        }

        if (value.equals(DIVIDE)) {
            result = calculator.divide(result, second);
        }
        return result;
    }
}
