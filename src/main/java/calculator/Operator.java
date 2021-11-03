package calculator;

import java.util.Arrays;

public enum Operator {
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
            if (y == 0) throw new IllegalArgumentException("can't divide with 0");
            return x / y;
        }
    };

    private String symbol;

    Operator(String symbol) {
            this.symbol = symbol;
    }

    public abstract int operate(int x, int y);

    public static boolean isOperator(String s) {
        return Arrays.stream(Operator.values()).anyMatch((o) -> o.symbol.equals(s));
    }

    public static Operator get(String s) {
        return Arrays.stream(Operator.values()).filter((o) -> o.symbol.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("variable is not operator"));
    }
}