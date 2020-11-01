package study;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperateType {
    SUM("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b <= 0) {
            throw new ArithmeticException("ArithmeticException");
        }
        return a / b;
    });

    private String operator;
    private BiFunction<Double, Double, Double> expression;

    OperateType(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static double operate(String operator, double a, double b) {
        return getOperator(operator).expression.apply(a, b);
    }

    private static OperateType getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findAny().orElseThrow(IllegalArgumentException::new);
    }
}
