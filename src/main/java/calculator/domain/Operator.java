package calculator.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {
    PLUS("+") {
        @Override
        public double operate(final double number1, final double number2) {
            return number1 + number2;
        }
    },
    MINUS("-") {
        @Override
        public double operate(double number1, double number2) {
            return number1 - number2;
        }
    },
    MULTIPLY("*") {
        @Override
        public double operate(double number1, double number2) {
            return number1 * number2;
        }
    },
    DIVIDE("/") {
        @Override
        public double operate(double number1, double number2) {
            return number1 / number2;
        }
    };

    private final String symbol;

    Operator(final String symbol) {
        this.symbol = symbol;
    }

    public abstract double operate(final double number1, final double number2);

    public static Optional<Operator> fromString(String symbol) {
        return Arrays.stream(Operator.values())
            .filter(v -> v.symbol.equalsIgnoreCase(symbol))
            .findFirst();
    }
}
