package calculator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    ADD("+", (num1, num2) -> (num1 + num2)),
    SUBTRACT("-", (num1, num2) -> (num1 - num2)),
    MULTIPLY("*", (num1, num2) -> (num1 * num2)),
    DIVIDE("/", (num1, num2) -> (num1 / num2));

    private String operator;
    private BiFunction<Double, Double, Double> biFunction;

    Operator(String operator, BiFunction<Double, Double, Double> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }

    public Double operate(Double num1, Double num2) {
        return this.biFunction.apply(num1, num2);
    }
}
