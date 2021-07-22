package calculator;

public class Calculator {

    private static final int ZERO = 0;

    public int calculate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Required not null");
        }
        String[] inputs = input.split(" ");
        if (inputs.length == ZERO) {
            throw new IllegalArgumentException("Required not blank");
        }
        int first = toInt(inputs[0]);
        for(int index=1; index<inputs.length; index+=2) {
            int second = toInt(inputs[index+1]);
            String operator = inputs[index];

            first = operate(operator, first, second);
        }

        return first;
    }

    private int operate(String operator, int first, int second) {
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

}
