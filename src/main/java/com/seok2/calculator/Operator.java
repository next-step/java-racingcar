package com.seok2.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator find(String operator) {
        return Arrays.stream(values())
            .filter(x -> x.operator.equals(operator))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    public Integer calculator(int num1, int num2) {
        return this.expression.apply(num1,num2);
    }
}
