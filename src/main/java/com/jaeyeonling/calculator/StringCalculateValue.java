package com.jaeyeonling.calculator;

import com.jaeyeonling.calculator.provider.OperatorProvider;
import com.jaeyeonling.calculator.type.Operator;

public class StringCalculateValue {

    private static final OperatorProvider operatorProvider = new OperatorProvider();
    private static final String SEPARATOR = " ";

    private final String[] splitValue;

    private StringCalculateValue(final String[] splitValue) {
        this.splitValue = splitValue;

        checkConstraints();
    }

    public static StringCalculateValue text(final String text) {
        if (isInvalidText(text)) {
            throw new IllegalArgumentException();
        }

        return new StringCalculateValue(text.split(SEPARATOR));
    }

    //
    //
    //

    public int calculate() {
        int result = getValue(0);
        for (int i = 1; i < length(); i += 2) {
            result = getOperator(i).apply(result, getValue(i + 1));
        }

        return result;
    }

    public int length() {
        return splitValue.length;
    }

    public int getValue(final int index) {
        return Integer.parseInt(splitValue[index]);
    }

    public Operator getOperator(final int index) {
        return operatorProvider.symbol(splitValue[index]);
    }

    //
    //
    //

    private static boolean isInvalidText(final String text) {
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
