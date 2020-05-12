package com.cheolhyeonpark.step2;

import java.util.Arrays;

public class StringCalculator {

    public int calculate(String input) {
        if (input == null || input.replaceAll(" ", "").length() < 1) {
            throw new IllegalArgumentException("There is no input. Please check your input data.");
        }
        String expression = input.replaceAll(" ", "");
        String[] numberStrings = expression.split("[\\+\\-\\*\\/]");
        String[] operators = expression.replaceAll("[0-9]", "").split("");

        int result = Integer.parseInt(numberStrings[0]);
        for (int i = 0; i < operators.length; i++) {
            int a = result;
            int b = Integer.parseInt(numberStrings[i + 1]);
            if (operators[i].equals("+")) {
                result = a + b;
            }
            if (operators[i].equals("-")) {
                result = a - b;
            }
            if (operators[i].equals("*")) {
                result = a * b;
            }
            if (operators[i].equals("/")) {
                result = a / b;
            }
        }
        return result;
    }
}
