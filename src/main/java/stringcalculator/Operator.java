package stringcalculator;

import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);
    private final String symbol;
    private final BinaryOperator<Integer> operator;

    Operator(String symbol, BinaryOperator<Integer> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public int operate(int x, int y) {
        return operator.apply(x, y);
    }
}
