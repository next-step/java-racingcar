package step2;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    DIVIDE("/", (a, b) -> a / b),
    MULTIPLY("*", (a, b) -> a * b);

    private String operator;
    private BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }


    public static Operator getOperationSymbol(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산기호가 아닙니다." + operator));
    }

    public double operate(double a, double b) {
        return expression.apply(a, b);
    }
}
