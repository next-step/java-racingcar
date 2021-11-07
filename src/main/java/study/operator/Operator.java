package study.operator;

import java.util.Arrays;

public enum Operator {
    PLUS("+") {
        public int operate(int first, int second) {
            return first + second;
        }
    },
    MINUS("-") {
        public int operate(int first, int second) {
            return first - second;
        }
    },
    TIMES("*") {
        public int operate(int first, int second) {
            return first * second;
        }
    },
    DIVIDE("/") {
        public int operate(int first, int second) {
            return first / second;
        }
    };

    private final String symbol;

    public abstract int operate(int first, int second);

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator findBy(String symbol) {
        return Arrays.stream(values())
                     .filter(operator -> symbol.equals(operator.symbol))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException("not supported operator."));
    }
}
