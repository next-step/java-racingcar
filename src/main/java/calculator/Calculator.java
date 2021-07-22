package calculator;

public class Calculator {

    private static final String ADD = "+";
    private static final String SUBSTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public int calculate(String input) {
        validate(input);

        String[] inputs = input.split(" ");
        int first = toInt(inputs[0]);
        for (int index = 1; index < inputs.length; index += 2) {
            first = operate(first, inputs[index], toInt(inputs[index + 1]));
        }
        return first;
    }

    private int operate(int first, String operator, int second) {
        if (operator.equals(ADD)) {
            return add(first, second);
        }
        if (operator.equals(SUBSTRACT)) {
            return subtract(first, second);
        }
        if (operator.equals(MULTIPLY)) {
            return multiply(first, second);
        }
        if (operator.equals(DIVIDE)) {
            return divide(first, second);
        }
        throw new IllegalArgumentException("Required correct operator!");
    }

    private int add(int first, int second) {
        return first + second;
    }

    private int subtract(int first, int second) {
        return first - second;
    }

    private int multiply(int first, int second) {
        return first * second;
    }

    private int divide(int first, int second) {
        if (second == 0) {
            throw new ArithmeticException("Number not divided by zero.");
        }
        return first / second;
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Required not null or empty");
        }
    }

}
