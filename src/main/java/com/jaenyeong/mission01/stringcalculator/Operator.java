package com.jaenyeong.mission01.stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", Integer::sum),
    SUBTRACTION("-", (firstOp, secondOp) -> firstOp - secondOp),
    MULTIPLICATION("*", (firstOp, secondOp) -> firstOp * secondOp),
    DIVISION("/", (firstOp, secondOp) -> firstOp / secondOp);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(final String operator, final BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int calculate(final String operator, final int firstOp, final int secondOp) {
        return getOperator(operator).expression
            .apply(firstOp, secondOp);
    }

    public static Operator getOperator(final String operator) {
        return Arrays.stream(values())
            .filter(op -> op.operator.equals(operator))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("operator is not valid"));
    }
}
