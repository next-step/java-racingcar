package stringCalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (e1, e2) -> e1 + e2),
    MINUS("-", (e1, e2) -> e1 - e2),
    MULTIPLY("*", (e1, e2) -> e1 * e2),
    DIVISION("/", (e1, e2) -> e1 / e2);

    private String operator;
    private BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static double calculate(String operator, double e1, double e2) {
        return validOperator(operator).expression.apply(e1, e2);
    }

    private static Operator validOperator(String operator) {
        return Arrays.stream(values())
                     .filter(o -> o.operator.equals(operator))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다!"));
    }

}
