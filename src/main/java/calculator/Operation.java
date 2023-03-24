package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {

    ADD("+", (x, y) -> x + y),
    MIN("-", (x, y) -> x - y),
    MUL("*", (x, y) -> x * y),
    DIV("/", (x, y) -> x / y);

    private final String symbol;
    private final BiFunction<Double, Double, Double> function;

    Operation(String symbol, BiFunction<Double, Double, Double> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public double execute(double x, double y) {
        if(this == DIV && y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return function.apply(x, y);
    }

    public static Operation findBySymbol(String symbol) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자를 찾을 수 없습니다."));
    }
}
