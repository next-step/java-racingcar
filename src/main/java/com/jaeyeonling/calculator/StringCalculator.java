package com.jaeyeonling.calculator;

import com.jaeyeonling.calculator.type.Operator;

public final class StringCalculator {

    private static final int DEFAULT_INDEX = 0;
    private static final int START_INDEX = 1;
    private static final int CALCULATION_SIZE = 2;

    public static int calculate(final StringCalculateValue calculateValue) {
        int result = calculateValue.getValue(DEFAULT_INDEX);
        for (int i = START_INDEX; i < calculateValue.length(); i += CALCULATION_SIZE) {
            final Operator operator = calculateValue.getOperator(i);
            final int nextValue = calculateValue.getValue(i + START_INDEX);

            result = operator.apply(result, nextValue);
        }

        return result;
    }
}
