package calculator;

import java.util.Arrays;

public class StringCalculator {

    private static final String supportOperator = "+-*/";

    public int calculate(String input) {
        if (input == null || input.isEmpty() || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] splitInput = input.split(" ");

        int result = Integer.parseInt(splitInput[0]);

        if (splitInput.length == 1) {
            return result;
        }

        if (splitInput.length == 2) {
            throw new IllegalArgumentException();
        }

        return calculate(splitInput[0], splitInput[1], splitInput[2], Arrays.copyOfRange(splitInput, 3, splitInput.length));
    }

    private int calculate(String number1, String operator, String number2, String[] other) {
        if (!supportOperator.contains(operator)) {
            throw new IllegalArgumentException();
        }

        if (other.length == 1) {
            throw new IllegalArgumentException();
        }

        int result = Integer.parseInt(number1);

        if (operator.equals("+")) {
            result += Integer.parseInt(number2);
        }
        if (operator.equals("-")) {
            result -= Integer.parseInt(number2);
        }
        if (operator.equals("*")) {
            result *= Integer.parseInt(number2);
        }
        if (operator.equals("/")) {
            result /= Integer.parseInt(number2);
        }

        if (other == null || other.length == 0) {
            return result;
        }

        return calculate(String.valueOf(result), other[0], other[1], Arrays.copyOfRange(other, 2, other.length));
    }

}
