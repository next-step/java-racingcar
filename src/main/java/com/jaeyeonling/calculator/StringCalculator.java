package com.jaeyeonling.calculator;

public class StringCalculator {

    private static final Calculator calculator = new Calculator();

    public int calculate(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        final String[] splitInput = input.split(" ");

        final String operator = splitInput[1];
        if ("+".equals(operator)) {
            return calculator.add(Integer.valueOf(splitInput[0]), Integer.valueOf(splitInput[2]));
        }
        if ("-".equals(operator)) {
            return calculator.subtract(Integer.valueOf(splitInput[0]), Integer.valueOf(splitInput[2]));
        }
        if ("*".equals(operator)) {
            return calculator.multiply(Integer.valueOf(splitInput[0]), Integer.valueOf(splitInput[2]));
        }
        if ("/".equals(operator)) {
            return calculator.divide(Integer.valueOf(splitInput[0]), Integer.valueOf(splitInput[2]));
        }

        throw new IllegalArgumentException();
    }
}
