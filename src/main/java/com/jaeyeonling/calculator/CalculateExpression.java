package com.jaeyeonling.calculator;

import com.jaeyeonling.calculator.type.Operator;

import java.util.regex.Pattern;

public class CalculateExpression {

    private static final String REGEX_EXPRESSION = "^(\\d+)(?:\\s+[\\+\\-\\*\\/]{1}\\s+(\\d+))+$";
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile(REGEX_EXPRESSION);
    private static final String SEPARATOR = " ";

    private final String[] splitValue;

    private CalculateExpression(final String[] splitValue) {
        this.splitValue = splitValue;
    }

    public static CalculateExpression ofExpression(final String expression) {
        if (isInvalidExpression(expression)) {
            throw new IllegalArgumentException("올바르지 않은 Expression");
        }

        return new CalculateExpression(expression.split(SEPARATOR));
    }

    int length() {
        return splitValue.length;
    }

    int getValue(final int index) {
        return Integer.parseInt(splitValue[index]);
    }

    Operator getOperator(final int index) {
        return Operator.symbol(splitValue[index]);
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
