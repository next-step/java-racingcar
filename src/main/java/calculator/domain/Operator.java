package calculator.domain;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
    PLUS("+") {
        public int operate(int prevNumber, int nextNumber) {
            return prevNumber + nextNumber;
        }
    },
    MINUS("-") {
        public int operate(int prevNumber, int nextNumber) {
            return prevNumber - nextNumber;
        }
    },
    TIMES("*") {
        public int operate(int prevNumber, int nextNumber) {
            return prevNumber * nextNumber;
        }
    },
    DIVIDE("/") {
        public int operate(int prevNumber, int nextNumber) {
            if (nextNumber == 0) {
                throw new ArithmeticException("[ERROR] 0으로 나눌 수 없습니다.");
            }
            return prevNumber / nextNumber;
        }
    };

    private String symbol;
    private static final Map<String, Operator> BY_SYMBOL = new HashMap<>();
    Operator(String symbol) {
        this.symbol = symbol;
    }

    static {
        for (Operator operator : values()) {
            BY_SYMBOL.put(operator.symbol, operator);
        }
    }

    public static Operator getType(String symbol) {
        return BY_SYMBOL.get(symbol);
    }

    public static boolean isOperator(String symbol) {
        return BY_SYMBOL.containsKey(symbol);
    }

    public abstract int operate(int prevNumber, int nextNumber);
}
