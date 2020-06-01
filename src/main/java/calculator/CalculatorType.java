package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculatorType {
    plus("+", (a, b) -> a + b),
    minus("-", (a, b) -> a - b),
    multiply("*", (a, b) -> a * b),
    divide("/", (a, b) -> a / b);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    CalculatorType(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static int calculate (String symbol, int a, int b) {
        return getSymbol(symbol).expression.apply(a, b);
    }

    private static CalculatorType getSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(s -> s.symbol.equals(symbol))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아님"));
    }
}
