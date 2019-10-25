package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * Created by kohyusik on 25/10/2019.
 */
public enum Operator {

    ADDITION("+", (a, b) -> a + b),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b),
    ;

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public String getSymbol() {
        return symbol;
    }

    public int operate(int a, int b) {
        return function.apply(a, b);
    }

    public static Operator of(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.getSymbol().equals(symbol))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Not support operator. [" + symbol + "]"));
    }
}