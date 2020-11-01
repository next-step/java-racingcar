package step2;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public enum Operator {
    ADD(     "+", (lhs, rhs) -> lhs + rhs), // can be replaced with Integer::sum
    SUBTRACT("-", (lhs, rhs) -> lhs - rhs),
    MULTIPLY("*", (lhs, rhs) -> lhs * rhs),
    DIVIDE(  "/", (lhs, rhs) -> lhs / rhs);

    static final Map<String, Operator> symbolMapping =
            Arrays.stream(values()).collect(
                    Collectors.toUnmodifiableMap(op -> op.symbol, Function.identity())
            );

    final String symbol;
    final IntBinaryOperator operation;  // more exact than BiFunction<Integer, Integer, Integer>

    Operator(String symbol, IntBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator parseOperator(String symbol) {
        Operator res = symbolMapping.get(symbol);
        if(res == null) throw new IllegalArgumentException();
        return res;
    }

    public int operate(int lhs, int rhs) {
        try {
            return operation.applyAsInt(lhs, rhs);
        } catch(ArithmeticException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
