package com.jaeyeonling.calculator;

public class StringCalculator {

    private static final Calculator calculator = new Calculator();

    public int calculate(final String input) {
        final String[] splitInput = input.split(" ");

        if ("+".equals(splitInput[1])) {
            return calculator.add(Integer.valueOf(splitInput[0]), Integer.valueOf(splitInput[2]));
        }
        if ("-".equals(splitInput[1])) {
            return calculator.subtract(Integer.valueOf(splitInput[0]), Integer.valueOf(splitInput[2]));
        }

        return 0;
    }
}
