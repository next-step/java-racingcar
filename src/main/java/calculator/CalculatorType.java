package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculatorType {
    plus("+", (num1, num2) -> num1 + num2),
    minus("-", (num1, num2) -> num1 - num2),
    multiply("*", (num1, num2) -> num1 * num2),
    divide("/", (num1, num2) -> num1 / num2);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    CalculatorType(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static int calculate (String symbol, int num1, int num2) {
        return getSymbol(symbol).expression.apply(num1, num2);
    }

    private static CalculatorType getSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(s -> s.symbol.equals(symbol))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아님"));
    }
}
