package stringCalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private String operator;
    private BiFunction<Double, Double, Double> calculate;

    Operator(String operator, BiFunction<Double, Double, Double> calculate) {
        this.operator = operator;
        this.calculate = calculate;
    }

    public double calculate(double a, double b) {
        return calculate.apply(a, b);
    }

    public static Operator validOperator(String operator) {
        return Arrays.stream(values())
                     .filter(o -> o.operator.equals(operator))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다!"));
    }
}
