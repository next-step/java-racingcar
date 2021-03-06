package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b);

    private String symbol;
    private BiFunction<Long, Long, Long> expression;

    Operator(String symbol, BiFunction<Long, Long, Long> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public long calculate(long a, long b) {
        return expression.apply(a, b);
    }

    public static Operator findOperator(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(e -> e.symbol.equals(symbol))
                .findFirst().get();
    }
}
