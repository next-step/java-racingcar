package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b);

    private String Symbol;
    private BiFunction<Long, Long, Long> expression;

    Operator(String Symbol, BiFunction<Long, Long, Long> expression) {
        this.Symbol = Symbol;
        this.expression = expression;
    }

    public long calculate(long a, long b) {
        return expression.apply(a, b);
    }

    public static Operator findOperator(String Symbol) {
        return Arrays.stream(Operator.values())
                .filter(e -> e.Symbol.equals(Symbol))
                .findFirst().get();
    }
}
