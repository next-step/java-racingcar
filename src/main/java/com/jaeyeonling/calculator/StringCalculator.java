package com.jaeyeonling.calculator;

import com.jaeyeonling.calculator.type.Operator;

public final class StringCalculator {

    private static final int DEFAULT_INDEX = 0;
    private static final int START_INDEX = 1;
    private static final int CALCULATION_SIZE = 2;

    private StringCalculator() { }

    public static int calculate(final CalculateExpression expression) {
        int result = expression.getValue(DEFAULT_INDEX);
        for (int i = START_INDEX; i < expression.length(); i += CALCULATION_SIZE) {
            final Operator operator = expression.getOperator(i);
            final int nextValue = expression.getValue(i + START_INDEX);

            result = operator.apply(result, nextValue);
        }

        return result;
    }
}
