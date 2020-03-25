package calculator;

import java.util.stream.Stream;

public enum Operator {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    }, MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    }, MULTIPLY("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    }, DIVIDE("/") {
        public double apply(double x, double y) {
            if (y == 0) {
                throw new IllegalArgumentException("cannot be divided zero");
            }
            return x / y;
        }
    };

    Operator(String symbol) {
        this.symbol = symbol;
    }

    private String symbol;

    public abstract double apply(double x, double y);

    public static Operator getOperator(String str) {
        return Stream.of(values())
                .filter(operator -> operator.symbol.equals(str))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("invalid operator"));
    }

    @Override
    public String toString() {
        return symbol;
    }
}
