package calculator;

import java.util.Map;
import java.util.Optional;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> (left / right));

    private final IntBinaryOperator intBinaryOperator;
    private final String symbol;
    private static final Map<String, Operator> OPERATOR_MAP =
            Stream.of(Operator.values()).collect(toMap(o -> o.symbol, o -> o));

    Operator(String symbol, IntBinaryOperator intBinaryOperator) {
        this.symbol = symbol;
        this.intBinaryOperator = intBinaryOperator;
    }

    public static Operator of(String symbol) {
        return Optional.ofNullable(OPERATOR_MAP.get(symbol))
                .orElseThrow(() -> new IllegalArgumentException("부적절한 기호 입니다."));
    }

    public int operate(int leftOp, int rightOp) {
        return intBinaryOperator.applyAsInt(leftOp, rightOp);
    }
}
