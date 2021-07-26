package com.racingcar.calculator;

import com.racingcar.calculator.operator.Operator;
import com.racingcar.calculator.operator.StringOperator;

import java.util.Objects;

public class StringCalculator {
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private static final Operator operator = new StringOperator();

    public static int calculate(String input) {
        validate(input);

        String[] values = input.split(" ");

        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            String operatorSign = values[i];
            int operatedValue = Integer.parseInt(values[i + 1]);
            result = calculate(operatorSign, result, operatedValue);
        }

        return result;
    }

    private static void validate(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("input String is null");
        }
    }

    private static int calculate(String operatorSign, int value01, int value02) {
        if (ADD.equals(operatorSign)) {
            return operator.add(value01, value02);
        } else if (SUBTRACT.equals(operatorSign)) {
            return operator.subtract(value01, value02);
        } else if (MULTIPLY.equals(operatorSign)) {
            return operator.multiply(value01, value02);
        } else if (DIVIDE.equals(operatorSign)) {
            return operator.divide(value01, value02);
        }

        throw new IllegalArgumentException("Invalid Operator - target is " + operatorSign);
    }
}
