package study.operator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    TIMES("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> first / second);

    private static final String INVALID_OPERATOR_EXCEPTION_MESSAGE = "not supported operator.";

    private final String symbol;
    private BiFunction<Integer, Integer, Integer> operate;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    public int operate(int first, int second) {
        return operate.apply(first, second);
    }

    public static Operator findBy(String symbol) {
        return Arrays.stream(values())
                     .filter(operator -> symbol.equals(operator.symbol))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATOR_EXCEPTION_MESSAGE));
    }
}
