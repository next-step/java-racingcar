package com.kimdahyeee.calculator;

public class Calculator {
    private static final String SEPARATOR = " ";

    public int calculate(String expression) {
        mustNotBeNullOrEmpty(expression);
        String[] values = separateExpressionByBlank(expression);

        return execute(values);
    }

    private void mustNotBeNullOrEmpty(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private String[] separateExpressionByBlank(String expression) {
        return expression.split(SEPARATOR);
    }

    private int execute(String[] values) {
        int index = 0;
        int result = convertStringToInt(values[index++]);

        for (int i = index; i < values.length; i++) {
            result = Operator.operation(values[i], convertStringToInt(values[++i]), result);
        }

        return result;
    }

    private int convertStringToInt(String value) {
        return Integer.parseInt(value);
    }

}
