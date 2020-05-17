package caculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (left, right) -> left + right),
    SUBTRACTION("-", (left, right) -> left - right),
    DIVISION("/", (left, right) -> left / right),
    MULTIPLY("*", (left, right) -> left * right);

    private final String operator;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static double calculate(final double left, final String operator, final double right) {
        return find(operator).expression.apply(left, right);
    }

    public static double calculate(final double left, final String operator, final String right) {
        return calculate(left, operator, Double.parseDouble(right));
    }

    private static Operator find(final String operator) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", operator)));
    }
}
