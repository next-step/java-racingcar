package stringcalculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

import static stringcalculator.Message.UNSUPPORTED_OPERATOR;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        Validator.checkZero(y);
        return x / y;
    });
    private final String symbol;
    private final BinaryOperator<Integer> operator;

    Operator(String symbol, BinaryOperator<Integer> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static Operator operateOf(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(e -> e.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(UNSUPPORTED_OPERATOR));
    }

    public int operate(int x, int y) {
        return operator.apply(x, y);
    }
}
