package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS((x, y) -> x + y),
    MINUS((x, y) -> x - y),
    MULTIPLY((x, y) -> x * y),
    DIVIDE((x, y) -> {
        if (y == 0) {
            throw new IllegalArgumentException(ExceptionMessage.DIVIDED_BY_ZERO.getMessage());
        }
        return x / y;
    });

    private static final Map<String, Operator> BY_SYMBOL = new HashMap<>();

    private final BinaryOperator<Integer> operation;

    Operator(BinaryOperator<Integer> operation) {
        this.operation = operation;
    }

    static {
        BY_SYMBOL.put("+", PLUS);
        BY_SYMBOL.put("-", MINUS);
        BY_SYMBOL.put("*", MULTIPLY);
        BY_SYMBOL.put("/", DIVIDE);
    }

    public static Operator of(String symbol) {
        return Optional.ofNullable(BY_SYMBOL.get(symbol))
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_ARITHMETIC_OPERATOR.getMessage()));
    }

    public Integer compute(int x, int y) {
        return this.operation.apply(x, y);
    }
}
