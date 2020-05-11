package calculator;

import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private final String operatorName;
    private final BiFunction<Double, Double, Double> operatorFunc;

    Operator(String operatorName, BiFunction<Double, Double, Double> operatorFunc) {
        this.operatorName = operatorName;
        this.operatorFunc = operatorFunc;
    }

    public double calculate(String s, double number1, double number2) {
        return this.operatorFunc.apply(number1, number2);
    }

}
