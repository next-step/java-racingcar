package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (number1, number2) -> number1 + number2),
    SUBTRACT("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", (number1, number2) -> {
        final Double divided = number1 / number2;
        if (divided.isInfinite()) {
            throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다.");
        }
        return round(divided);
    });

    private final String symbol;
    private final BiFunction<Double, Double, Double> operator;

    Operator(String symbol, BiFunction<Double, Double, Double> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    private static double round(Double number) {
        return Math.round((number) * Math.pow(10, 2)) / Math.pow(10, 2);
    }

    public static Operator operatorOf(String symbol) {
        return Arrays.stream(Operator.values())
            .filter(operator -> symbol.equals(operator.symbol))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 사칙연산 기호가 아닙니다."));
    }

    public double apply(Double number1, Double number2) {
        return operator.apply(number1, number2);
    }

}

