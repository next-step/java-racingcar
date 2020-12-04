package calculator.domain;

import java.util.function.BiFunction;

public enum Operator {
    ADD(Double::sum),
    SUBTRACT((num1, num2) -> num1 - num2),
    MULTIPLY((num1, num2) -> num1 * num2),
    DIVIDE((num1, num2) -> num1 / num2);

    private final BiFunction<Double, Double, Double> expression;

    Operator(BiFunction<Double, Double, Double> expression) {
        this.expression = expression;
    }

    public double calculate(Double num1, Double num2) {
        return expression.apply(num1, num2);
    }
}
