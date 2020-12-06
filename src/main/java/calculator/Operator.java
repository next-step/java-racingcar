package calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.IntBinaryOperator;

public enum Operator {

    PLUS('+', Integer::sum),
    MINUS('-', (left, right) -> left - right),
    MULTIPLY('*', (left, right) -> left * right),
    DIVIDE('/', (left, right) -> left / right);

    private final char symbol;
    private final IntBinaryOperator operator;

    Operator(char symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public char getSymbol() {
        return symbol;
    }

    public int apply(int left, int right) {
        return operator.applyAsInt(left, right);
    }

    public static Optional<Operator> of(char symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.getSymbol() == symbol)
                .findFirst();
    }

    public static int calculate(char symbol, int left, int right) {
        Operator operator = Operator.of(symbol)
                .orElseThrow(() -> new IllegalArgumentException("unknown operator symbol: " + symbol));
        return operator.apply(left, right);
    }
}
