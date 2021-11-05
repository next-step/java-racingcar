package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (first, second) -> Number.from(first.getNumber() + second.getNumber())),
    MINUS("-", (first, second) -> Number.from(first.getNumber() - second.getNumber())),
    MUL("*", (first, second) -> Number.from(first.getNumber() * second.getNumber())),
    DIV("/", (first, second) -> Number.from(first.getNumber() / second.getNumber()));

    private final String symbol;
    private final BiFunction<Number, Number, Number> calculate;

    Operator(String symbol, BiFunction<Number, Number, Number> calculate) {
        this.symbol = symbol;
        this.calculate = calculate;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Number calculate(Number first, Number second) {
        return this.calculate.apply(first, second);
    }
}
