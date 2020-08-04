package calculator;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Operation {
    ADDITION("+") {
        @Override
        double calculate(double x, double y) {
            BigDecimal x1 = new BigDecimal(x);
            BigDecimal y1 = new BigDecimal(y);

            return x1.add(y1).doubleValue();
        }
    },
    SUBTRACTION("-") {
        @Override
        double calculate(double x, double y) {
            BigDecimal x1 = new BigDecimal(x);
            BigDecimal y1 = new BigDecimal(y);

            return x1.subtract(y1).doubleValue();
        }
    },
    MULTIPLICATION("*") {
        @Override
        double calculate(double x, double y) {
            BigDecimal x1 = new BigDecimal(x);
            BigDecimal y1 = new BigDecimal(y);

            return x1.multiply(y1).doubleValue();
        }
    },
    DIVISION("/") {
        @Override
        double calculate(double x, double y) {
            if (y == 0) {
                throw new ArithmeticException(ExceptionMessage.DIVISION_BY_ZERO);
            }

            BigDecimal x1 = new BigDecimal(x);
            BigDecimal y1 = new BigDecimal(y);

            return x1.divideToIntegralValue(y1).doubleValue();
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static Operation of(String symbol) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_OPERATION_SYMBOL));
    }

    public String getSymbol() {
        return symbol;
    }

    abstract double calculate(double x, double y);

}
