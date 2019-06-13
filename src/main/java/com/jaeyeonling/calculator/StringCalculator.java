package com.jaeyeonling.calculator;

public class StringCalculator {

    private static final Calculator calculator = new Calculator();

    public int calculate(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        final String[] splitInput = input.split(" ");

        int result = Integer.valueOf(splitInput[0]);
        for (int i = 1; i < splitInput.length; i += 2) {
            final String operator = splitInput[i];
            final int number = Integer.valueOf(splitInput[i + 1]);

            result = calculate(operator, result, number);
        }

        return result;
    }

    private int calculate(final String operator, final int a, final int b) {
        if ("+".equals(operator)) {
            return calculator.add(a, b);
        }
        if ("-".equals(operator)) {
            return calculator.subtract(a, b);
        }
        if ("*".equals(operator)) {
            return calculator.multiply(a, b);
        }
        if ("/".equals(operator)) {
            return calculator.divide(a, b);
        }

        throw new IllegalArgumentException();
    }
}
