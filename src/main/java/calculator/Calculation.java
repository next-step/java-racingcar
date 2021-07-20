package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculation {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLE("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        validToDivideByZero(b);
        return a / b;
    });

    private String expressionLabel;
    private BiFunction<Integer, Integer, Integer> calculateValue;

    Calculation(String expressionLabel, BiFunction<Integer, Integer, Integer> calculateValue) {
        this.expressionLabel = expressionLabel;
        this.calculateValue = calculateValue;
    }

    public static int calculateValue(String expressionLabel, int firstValue, int lastValue) {
        return getExpression(expressionLabel).calculateValue.apply(firstValue, lastValue);
    }

    private static Calculation getExpression(String expressionLabel) {
        return Arrays.stream(values())
                .filter(o -> o.expressionLabel.equals(expressionLabel))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }

    private static void validToDivideByZero(int lastValue) {
        if (lastValue == 0) {
            throw new IllegalArgumentException("0으로 나눗셈은 불가능 합니다.");
        }
    }

}
