package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", (first, second) -> first.add(second)),
    MINUS("-", (first, second) -> first.subtract(second)),
    TIMES("*", (first, second) -> first.multiply(second)),
    DIVIDE("/", (first, second) -> first.divide(second));

    private String operator;
    private BinaryOperator<Operand> operation;

    Operator(String operator, BinaryOperator<Operand> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(operator + "는 사칙연산 기호가 아닙니다."));
    }

    public Operand operate(Operand first, Operand second) {
        return operation.apply(first, second);
    }

    public boolean equals(String operator) {
        return this.operator.equals(operator);
    }

}
