package calculator.util;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {
    PLUS  ("+", (x, y) -> x + y),
    MINUS ("-", (x, y) -> x - y),
    TIMES ("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static Optional<Operation> from(String symbol) {
        return Arrays.stream(values())
            .filter(operation -> operation.isSameSymbol(symbol))
            .findAny();
    }

    private boolean isSameSymbol(String symbol) {
        return this.symbol.equals(symbol);
    }
}
