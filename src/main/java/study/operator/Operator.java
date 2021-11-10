package study.operator;

import java.util.Arrays;
import java.util.function.BiFunction;

import study.IntNumber;

public enum Operator {
    PLUS("+", IntNumber::plus),
    MINUS("-", IntNumber::minus),
    TIMES("*", IntNumber::times),
    DIVIDE("/", IntNumber::divide);

    private static final String INVALID_OPERATOR_EXCEPTION_MESSAGE = "not supported operator.";

    private final String symbol;
    private BiFunction<IntNumber, IntNumber, IntNumber> operate;

    Operator(String symbol, BiFunction<IntNumber, IntNumber, IntNumber> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    public IntNumber operate(IntNumber first, IntNumber second) {
        return operate.apply(first, second);
    }

    public static Operator findBy(String symbol) {
        return Arrays.stream(values())
                     .filter(operator -> symbol.equals(operator.symbol))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATOR_EXCEPTION_MESSAGE));
    }
}
