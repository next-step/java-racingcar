package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculator {
    PLUS("+", (value1, value2) -> value1 + value2),
    MINUS("-", (value1, value2) -> value1 - value2),
    MULTIPLY("*", (value1, value2) -> value1 * value2),
    DIVIDE("/", (value1, value2) -> value1 / value2);

    private String operator;
    private BiFunction<Double, Double, Double> expression;

    private Calculator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static final Calculator findOperator(String op) {
        return Arrays.stream(values())
                .filter(x -> x.operator.equals(op))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
    }

    public double calculate(double value1, double value2) {
        return expression.apply(value1, value2);
    }
}
