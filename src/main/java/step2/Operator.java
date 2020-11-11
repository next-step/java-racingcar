package step2;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public enum Operator {
    ADD(     "+", Integer::sum),
    SUBTRACT("-", (lhs, rhs) -> lhs - rhs),
    MULTIPLY("*", (lhs, rhs) -> lhs * rhs),
    DIVIDE(  "/", (lhs, rhs) -> {
        if(rhs == 0) throw new IllegalArgumentException("divided by zero");
        return lhs / rhs;
    });

    private static final Map<String, Operator> symbolMapping =
            Arrays.stream(values()).collect(
                    Collectors.toUnmodifiableMap(op -> op.symbol, Function.identity())
            );

    private final String symbol;
    private final IntBinaryOperator operation;  // more exact than BiFunction<Integer, Integer, Integer>

    /* private */ Operator(String symbol, IntBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator parseOperator(String symbol) {
        Operator res = symbolMapping.get(symbol);
        if(res == null) throw new IllegalArgumentException("unknown operator symbol: " + symbol);
        return res;
    }

    public int operate(int lhs, int rhs) {
        return operation.applyAsInt(lhs, rhs);
    }
}
