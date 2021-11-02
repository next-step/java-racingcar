package step2;

import java.util.Arrays;

public enum Operation {

    PLUS("+") {
        public Integer apply(Integer left, Integer right) {
            return left + right;
        }
    },
    MINUS("-") {
        public Integer apply(Integer left, Integer right) {
            return left - right;
        }
    },
    TIMES("*") {
        public Integer apply(Integer left, Integer right) {
            return left * right;
        }
    },
    DIVIDE("/") {
        public Integer apply(Integer left, Integer right) {
            return left / right;
        }
    };
    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static Operation getOperation(String operator) {
        return Arrays.stream(values())
                .filter(item -> item.symbol.equals(operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract Integer apply(Integer left, Integer right);
}
