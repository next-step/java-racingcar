package calculator;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    ADD("+") {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT("-") {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(int x, int y) {
            return x / y;
        }
    };

    private final String symbol;
    private static final Map<String, Operation> OPERATION_MAP =
            Stream.of(values()).collect(Collectors.toMap(Operation::toString, e -> e));

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(int x, int y);

    public static Operation fromString(String symbol) {
        if(!OPERATION_MAP.containsKey(symbol)) {
            throw new RuntimeException("존재하지 않는 사칙연산 기호입니다.");
        }
        return OPERATION_MAP.get(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
