package com.seok2.calculator;

public class StringCalculator {

    public void checkIsEmpty(String expression) {
        if (isEmpty(expression)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEmpty(String expression) {
        return expression == null || expression.trim().length() == 0;
    }

    public int evaluate(String expression) {
        checkIsEmpty(expression);
        return calculate(split(expression));
    }

    private String[] split(String expression) {
        return expression.split(" ");
    }

    private int calculate(String[] array) {
        int result = Integer.parseInt(array[0]);
        for (int idx = 1; idx < array.length; idx += 2) {
            result = Operator.find(array[idx]).calculator(result, Integer.parseInt(array[idx + 1]));
        }
        return result;
    }
}
