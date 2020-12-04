package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    DIVIDE("/", (left, right) -> left / right),
    MULTIPLY("*", (left, right) -> left * right),
    ;

    private final BiFunction<Long, Long, Long> biFunction;
    private final String symbol;

    Operator(String symbol, BiFunction<Long, Long, Long> biFunction) {
        this.symbol = symbol;
        this.biFunction = biFunction;
    }

    public static long calculate(long left, long right, String symbol) {
        Operator operator = ofString(symbol);
        return operator.apply(left, right);
    }

    private long apply(long left, long right) {
        return biFunction.apply(left, right);
    }

    private static Operator ofString(String symbol) {
        return Arrays.stream(values())
                .filter((value) -> value.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
