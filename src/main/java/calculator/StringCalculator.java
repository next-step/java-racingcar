package calculator;
import java.util.InputMismatchException;

public class StringCalculator {

    public static int calculate(String text) throws InputMismatchException {
        if (text.equals("") || text == null) {
            throw new InputMismatchException();
        }

        try {
            String[] values = text.split(" ");
            int firstValue = Integer.parseInt(values[0]);
            for (int i = 1; i < values.length; ) {
                firstValue = calculationWithString(firstValue, values[i], Integer.parseInt(values[i + 1]));
                i += 2;
            }

            return firstValue;
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        }
    }

    public static int calculationWithString(int firstValue, String expression, int secondValue) throws InputMismatchException {
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
                throw new InputMismatchException();
        }
    }
}
