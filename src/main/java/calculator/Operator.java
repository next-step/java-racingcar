package calculator;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(int i, int i1) {
            return i + i1;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int i, int i1) {
            return i - i1;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int i, int i1) {
            return i * i1;
        }
    },
    SUBTRACT("/") {
        @Override
        public int calculate(int i, int i1) {
            if (i1 == 0) {
                throw new IllegalArgumentException();
            }
            return i / i1;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator find(String s) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public abstract int calculate(int i, int i1);
}
