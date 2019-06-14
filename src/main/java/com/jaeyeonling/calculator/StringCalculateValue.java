package com.jaeyeonling.calculator;

import com.jaeyeonling.calculator.provider.OperatorProvider;
import com.jaeyeonling.calculator.type.Operator;

public class StringCalculateValue {

    private static final String SEPARATOR = " ";

    private final String[] splitValue;

    private int result;
    private boolean executed = false;

    private StringCalculateValue(final String[] splitValue) {
        this.splitValue = splitValue;

        checkConstraints();
    }

    public static StringCalculateValue ofExpression(final String expression) {
        if (isInvalidExpression(expression)) {
            throw new IllegalArgumentException();
        }

        return new StringCalculateValue(expression.split(SEPARATOR));
    }

    public int getResult() {
        if (!isExecuted()) {
            calculate();
        }

        return result;
    }

    public void calculate() {
        if (isExecuted()) {
            return;
        }

        int result = getValue(0);
        for (int i = 1; i < length(); i += 2) {
            final Operator operator = getOperator(i);
            final int nextValue = getValue(i + 1);

            result = operator.apply(result, nextValue);
        }

        this.result = result;
        executed = true;
    }

    public int length() {
        return splitValue.length;
    }

    public int getValue(final int index) {
        return Integer.parseInt(splitValue[index]);
    }

    public Operator getOperator(final int index) {
        return OperatorProvider.symbol(splitValue[index]);
    }

    public boolean isExecuted() {
        return executed;
    }

    private static boolean isInvalidExpression(final String text) {
        return text == null || text.isEmpty();
    }

    private void checkConstraints() {
        if (isInvalidValueLength()) {
            throw new IllegalArgumentException();
        }

        checkValue(0);
        for (int i = 1; i < length(); i += 2) {
            checkOperator(i);
            checkValue(i + 1);
        }
    }

    private boolean isInvalidValueLength() {
        return length() < 2 || isEvenLength();
    }

    private boolean isEvenLength() {
        return length() / 2 == 0;
    }

    private void checkValue(final int index) {
        try {
            getValue(index);
        } catch (final NumberFormatException ignore) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOperator(final int index) {
        getOperator(index);
    }
}
