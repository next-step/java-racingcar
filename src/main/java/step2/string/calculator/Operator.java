package step2.string.calculator;


import java.util.Arrays;
import java.util.function.BiFunction;

import static java.util.stream.Collectors.toMap;

public enum Operator implements Operation {
    PLUS("+") {
        public int operate(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        public int operate(int x, int y) {
            return x - y;
        }
    },
    TIMES("*") {
        public int operate(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public int operate(int x, int y) {
            return x / y;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    private static Operator fromString(String symbol) {
        return Arrays.stream(values())
                .filter(op -> op.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Constants.IS_NOT_VALID_OPERATOR));
    }

    @Override
    public String toString() {
        return symbol;
    }

}
