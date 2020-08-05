package calculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    ADDITION("+", BigDecimal::add),
    SUBTRACTION("-", BigDecimal::subtract),
    MULTIPLICATION("*", BigDecimal::multiply),
    DIVISION("/", (x, y) -> {
        if (BigDecimal.ZERO.equals(y)) {
            throw new ArithmeticException(ExceptionMessage.DIVISION_BY_ZERO);
        }
        return x.divideToIntegralValue(y);
    });

    private final String symbol;
    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> calculate;

    Operation(String symbol, BiFunction<BigDecimal, BigDecimal, BigDecimal> calculate) {
        this.symbol = symbol;
        this.calculate = calculate;
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

    public double calculate(double x, double y) {
        return this.calculate.apply(BigDecimal.valueOf(x), BigDecimal.valueOf(y)).doubleValue();
    }

}
