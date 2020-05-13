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
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                result = Integer.parseInt(values[i]);
                continue;
            }

            result = Operator.operation(values[i], Integer.parseInt(values[++i]), result);
        }

        return result;
    }

}
