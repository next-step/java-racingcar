package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (number1, number2) -> number1 + number2),
    SUBTRACT("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", (number1, number2) -> {
        final int DIGIT = 2;
        if(Double.valueOf(number1 / number2).isInfinite()) {
            throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다.");
        }
        return
            Math.round((number1 / number2) * Math.pow(10, DIGIT)) / Math.pow(10, DIGIT);
    });

    private final String symbol;
    private final BiFunction<Double, Double, Double> operator;

    Operator(String symbol, BiFunction<Double, Double, Double> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public double apply(Double number1, Double number2) {
        return operator.apply(number1, number2);
    }

    public static Operator operatorOf(String symbol) {
        return Arrays.stream(Operator.values())
            .filter(operator -> symbol.equals(operator.symbol))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 사칙연산 기호가 아닙니다."));
    }

}

