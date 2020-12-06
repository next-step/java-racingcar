package com.ssabae.nextstep.racingcar.step02;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-06
 */
public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    TIMES("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public static Operator find(String operate) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operate))
                .findFirst()
                .orElse(null);
    }

    public static boolean isOperator(String str) {
        return find(str) != null;
    }

    public Integer operation(int a, int b) {
        return function.apply(a, b);
    }

}
