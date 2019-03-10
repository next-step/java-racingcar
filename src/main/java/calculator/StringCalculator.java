package calculator;

public class StringCalculator {
    static int calculate(String text) {
        if (text.equals("")) {
            return 0;
        }

        String[] values = text.split(" ");
        int firstValue = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; ) {
            firstValue = calculationWithString(firstValue, values[i], Integer.parseInt(values[i + 1]));
            i += 2;
        }

        return firstValue;
    }

    static int calculationWithString(int firstValue, String expression, int secondValue) {
        switch (expression) {
            case "+":
                return firstValue + secondValue;
            case "-":
                return firstValue - secondValue;
            case "*":
                return firstValue * secondValue;
            case "/":
                return firstValue / secondValue;
            default:
                return 0;
        }
    }
}
