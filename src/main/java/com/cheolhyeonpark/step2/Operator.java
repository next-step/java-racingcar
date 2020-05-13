package com.cheolhyeonpark.step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    TIMES("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("Wrong input! Can not be divided by 0.");
        }
        return a / b;
    });

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(operatorObject -> operatorObject.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Wrong input! Only numbers and operators are allowed."));
    }

    public int operate(int a, int b) {
        return expression.apply(a, b);
    }
}
