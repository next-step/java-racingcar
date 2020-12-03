package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    DIVIDE("/", (a, b) -> a / b),
    MULTIPLY("*", (a, b) -> a * b);

    public static Map<String, Operator> operatorMap = new HashMap<>();

    static {
        for (Operator operator : Operator.values()) {
            operatorMap.put(operator.symbol, operator);
        }
    }

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(final String symbol, final BiFunction<Integer, Integer, Integer> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public static Operator symbol(final String value) {
        Operator operator = operatorMap.get(value);
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
        }
        return operator;
    }

    public int calculate(final int number, final int other) {
        return function.apply(number, other);
    }

    public Number calculate(final Number number, final Number other) {
        return Number.valueOf(calculate(number.getValue(), other.getValue()));
    }
}
