package calculator.domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    TIMES("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> {
        if (right == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return left / right;
    });

    private final String symbol;
    private final BinaryOperator<Double> operator;

    Operator(String symbol, BinaryOperator<Double> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public Double apply(Double left, Double right) {
        return this.operator.apply(left, right);
    }

    public static boolean isOperator(String symbol) {
        return Arrays.stream(values())
                .anyMatch(operator -> operator.symbol.equals(symbol));
    }

    public static Operator of(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 연산자가 없습니다."));
    }
}
