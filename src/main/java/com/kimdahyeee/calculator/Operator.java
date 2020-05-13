package com.kimdahyeee.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVISION("/",
            (a, b) -> {
                if (b == 0) {
                    throw new ArithmeticException("0으로 나누기를 할 수 없습니다.");
                }

                return a / b;
            });

    private String sign;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String sign, BiFunction<Integer, Integer, Integer> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    private String getSign() {
        return sign;
    }

    private BiFunction<Integer, Integer, Integer> getExpression() {
        return expression;
    }

    public static int operation(String sign, int newVal, int untilVal) {
        return findBySign(sign).getExpression().apply(untilVal, newVal);
    }

    private static Operator findBySign(String sign) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.getSign().equals(sign))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
