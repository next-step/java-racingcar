package study;

import java.util.function.BiFunction;

public enum OperatorType {
    ADD('+', (a, b) -> a + b),
    SUBTRACT('-', (a, b) -> a - b),
    MULTIPLTY('*', (a, b) -> a * b),
    DIVIDE('/', (a, b) -> a / b);

    private char operator;
    private BiFunction<Integer, Integer, Integer> expression;

    OperatorType(char operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public char getOperator() {
        return operator;
    }

    public Integer calculate(Integer value1, Integer value2) {
        return expression.apply(value1, value2);
    }
}
