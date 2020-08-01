package stringcalculator;

import java.util.function.IntBinaryOperator;

public enum Operator {

    PLUS('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    MULTIPLY('*', (a, b) -> a * b),
    DIVIDE('/', (a, b) -> a / b);

    private final char symbol;
    private final IntBinaryOperator operator;

    Operator(char symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public int apply(int left, int right) {
        return operator.applyAsInt(left, right);
    }

    public char getSymbol() {
        return symbol;
    }
}
