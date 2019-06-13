package com.jaeyeonling.calculator;

public class StringCalculator {

    private static final Calculator calculator = new Calculator();

    public int calculate(final String input) {
        final String[] splitInput = input.split(" ");

        return calculator.add(Integer.valueOf(splitInput[0]), Integer.valueOf(splitInput[2]));
    }
}
