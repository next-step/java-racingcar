package calculator;

import java.util.function.BiFunction;

public enum Operator {

    ADD("+", (num1, num2) -> (num1 + num2)),
    SUBTRACT("-", (num1, num2) -> (num1 - num2)),
    MULTIPLY("*", (num1, num2) -> (num1 * num2)),
    DIVIDE("/", (num1, num2) -> (num1 / num2));

    private String sign;
    private BiFunction<Double, Double, Double> biFunction;

    Operator(String sign, BiFunction<Double, Double, Double> biFunction) {
        this.sign = sign;
        this.biFunction = biFunction;
    }

    public Double operate(Double num1, Double num2) {
        return this.biFunction.apply(num1, num2);
    }

}
