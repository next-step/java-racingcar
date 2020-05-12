package com.cheolhyeonpark.step2;

import java.util.Arrays;

public class StringCalculator {

    public int carculate(String input) {
        String expression = input.replace(" ", "");
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
