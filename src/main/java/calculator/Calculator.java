package calculator;

public class Calculator {

    private static final int VALID_LENGTH = 3;

    public int calculate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Required not null");
        }
        String[] inputs = input.split(" ");
        validate(inputs);

        String operator = inputs[1];
        int first = toInt(inputs[0]);
        int second = toInt(inputs[2]);

        if (operator.equals("+")) {
            return add(first, second);
        }
        if(operator.equals("-")) {
            return subtract(first, second);
        }
        if(operator.equals("*")) {
            return multiply(first, second);
        }
        if(operator.equals("/")) {
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

    private void validate(String[] inputs) {
        if (inputs.length != VALID_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
