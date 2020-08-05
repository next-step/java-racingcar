package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Operator {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE;

    private static final Map<String, Operator> BY_SYMBOL = new HashMap<>();

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
}
