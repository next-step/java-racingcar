package com.racingcar.calculator;

public class StringCalculator {
    public static int calculate(String input) {
        String[] values = input.split(" ");
        if ("+".equals(values[1])) {
            return add(Integer.parseInt(values[0]), Integer.parseInt(values[2]));
        }

        return subtract(Integer.parseInt(values[0]), Integer.parseInt(values[2]));
    }

    private static int add(int value1, int value2) {
        return value1 + value2;
    }

    private static int subtract(int value1, int value2) {
        return value1 - value2;
    }
}
