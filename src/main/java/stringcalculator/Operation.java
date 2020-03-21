package stringcalculator;

import java.util.stream.Stream;

public enum Operation {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static boolean isOperator(String expression) {
        return Stream.of(values())
                .anyMatch(op -> op.symbol.equals(expression));
    }

    public static Operation of(String expression) {
        return Stream.of(values())
                .filter(op -> expression.equals(op.symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 연산자입니다.", expression)));
    }

    public abstract double apply(double x, double y);
}
