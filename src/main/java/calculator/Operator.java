package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (a, b) -> a + b),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    final private String symbol;
    final private BiFunction<Integer, Integer, Integer> calcFunc;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> calcFunc) {
        this.symbol = symbol;
        this.calcFunc = calcFunc;
    }

    public int calculate(int a, int b) {
        return calcFunc.apply(a, b);
    }

    public String getSymbol() {
        return symbol;
    }

    public static boolean isOperator(String value) {
        try {
            parseOperator(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static Operator parseOperator(String value) {
        return Arrays.stream(Operator.values())
                .filter(e -> e.getSymbol().equals(value))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}

