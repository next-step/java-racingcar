package com.jaeyeonling.calculator;

import com.jaeyeonling.calculator.type.Operator;

import java.util.regex.Pattern;

public class StringCalculateValue {

    private static final String REGEX_EXPRESSION = "^(\\d+)(?:\\s+[\\+\\-\\*\\/]{1}\\s+(\\d+))+$";
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile(REGEX_EXPRESSION);
    private static final String SEPARATOR = " ";

    private static final int DEFAULT_INDEX = 0;
    private static final int START_INDEX = 1;
    private static final int CALCULATION_SIZE = 2;


    private final String[] splitValue;

    private int result;
    private boolean executed = false;

    private StringCalculateValue(final String[] splitValue) {
        this.splitValue = splitValue;
    }

    public static StringCalculateValue ofExpression(final String expression) {
        if (isInvalidExpression(expression)) {
            throw new IllegalArgumentException("올바르지 않은 Expression");
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

        int result = getValue(DEFAULT_INDEX);
        for (int i = START_INDEX; i < length(); i += CALCULATION_SIZE) {
            final Operator operator = getOperator(i);
            final int nextValue = getValue(i + START_INDEX);

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
        return Operator.symbol(splitValue[index]);
    }

    public boolean isExecuted() {
        return executed;
    }

    private static boolean isInvalidExpression(final String text) {
        return isEmpty(text) || isNotMatchExpression(text);
    }

    private static boolean isEmpty(final String text) {
        return text == null || text.isEmpty();
    }

    private static boolean isNotMatchExpression(final String text) {
        return !EXPRESSION_PATTERN.matcher(text).matches();
    }
}
