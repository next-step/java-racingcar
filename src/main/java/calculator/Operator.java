package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    PLUS((x, y) -> x + y),
    MINUS((x, y) -> x - y),
    MULTIPLY((x, y) -> x * y),
    DIVIDE((x, y) -> x / y);

    private static final Map<String, Operator> BY_SYMBOL = new HashMap<>();

    private final BiFunction<Integer, Integer, Integer> function;

    Operator(BiFunction<Integer, Integer, Integer> function) {
        this.function = function;
    }

    static {
        BY_SYMBOL.put("+", PLUS);
        BY_SYMBOL.put("-", MINUS);
        BY_SYMBOL.put("*", MULTIPLY);
        BY_SYMBOL.put("/", DIVIDE);
    }

    public static Operator of(String symbol) {
        return Optional.ofNullable(BY_SYMBOL.get(symbol))
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

    public Integer compute(int x, int y) {
        return this.function.apply(x, y);
    }
}
