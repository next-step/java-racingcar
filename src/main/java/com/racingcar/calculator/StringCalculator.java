package com.racingcar.calculator;

public class StringCalculator {
    public static int calculate(String input) {
        String[] values = input.split(" ");

        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            String operator = values[i];
            int operatedValue = Integer.parseInt(values[i+1]);
            if ("+".equals(operator)) {
                 result = add(result, operatedValue);
                 continue;
            } else if ("-".equals(operator)) {
                result = subtract(result, operatedValue);
                continue;
            } else if("/".equals(operator)) {
                result = divide(result, operatedValue);
                continue;
            }

            result = multiply(result, operatedValue);
        }


        return result;
    }

    private static int add(int value1, int value2) {
        return value1 + value2;
    }

    private static int subtract(int value1, int value2) {
        return value1 - value2;
    }

    private static int divide(int value1, int value2) {
        return value1 / value2;
    }

    private static int multiply(int value1, int value2) {
        return value1 * value2;
    }
}
