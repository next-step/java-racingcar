package step2.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y),
    ;

    private final String symbol;
//    private final IntBinaryOperator op;

    //TODO:: Operator 로직 검증은 계산기 구현시 이어서 진행하기
    Operation(final String symbol, final IntBinaryOperator op) {
        this.symbol = symbol;
//        this.op = op;
    }

//    public int apply(final int x, final int y) {
//        return op.applyAsInt(x, y);
//    }

    public static Operation symbolOf(final String symbol) {
        for (final Operation op : Operation.values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException();
    }

    public static List<String> getSupportedSymbols() {
        return Arrays.stream(Operation.values())
                .map(op -> op.symbol)
                .collect(Collectors.toList());
    }
}