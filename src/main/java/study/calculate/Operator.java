package study.calculate;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Number::plus),
    MINUS("-", Number::minus),
    TIMES("*", Number::times),
    DIVIDE("/", Number::divide);

    private static final String INVALID_OPERATOR_EXCEPTION_MESSAGE = "not supported operator.";

    private final String symbol;
    private BiFunction<Number, Number, Number> operate;

    Operator(String symbol, BiFunction<Number, Number, Number> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    public Number operate(Number first, Number second) {
        return operate.apply(first, second);
    }

    public static Operator findBy(String symbol) {
        return Arrays.stream(values())
                     .filter(operator -> symbol.equals(operator.symbol))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATOR_EXCEPTION_MESSAGE));
    }
}
