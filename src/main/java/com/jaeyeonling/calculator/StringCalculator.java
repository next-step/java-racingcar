package com.jaeyeonling.calculator;

public class StringCalculator {

    public int calculate(final String input) {
        final String[] splitInput = input.split(" ");
        return Integer.valueOf(splitInput[0]) + Integer.valueOf(splitInput[2]);
    }
}
