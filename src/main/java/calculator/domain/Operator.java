package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", Double::sum),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String type;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String type, BiFunction<Double, Double, Double> expression) {
        this.type = type;
        this.expression = expression;
    }

    public static Operator findByType(String type) {
        return Arrays.stream(values())
                .filter(value -> value.type.equals(type))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자입니다."));
    }

    public double calculate(Double num1, Double num2) {
        return expression.apply(num1, num2);
    }
}
