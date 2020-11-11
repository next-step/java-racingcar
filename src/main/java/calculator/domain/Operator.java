package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));

    private final String sign;
    private final BiFunction<Double, Double, Double> biFunction;

    Operator(String sign, BiFunction<Double, Double, Double> biFunction) {
        this.sign = sign;
        this.biFunction = biFunction;
    }

    public Double calculate(double a, double b) {
        return this.biFunction.apply(a,b);
    }

    public static Operator getOperator(String sign) {
        return Arrays.stream(values())
                .filter(operator -> operator.sign.equals(sign))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static boolean contains(String sign) {
        return Arrays.stream(values())
                .filter(operator -> operator.sign.equals(sign))
                .distinct()
                .count() > 0;
    }
}
