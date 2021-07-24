package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String operator;
    private final BiFunction<Double, Double, Double> biFunction;

    Operation(String operator, BiFunction<Double, Double, Double> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public static Double calculate(String operator, Double firstNumber, Double secondNumber) {
        return getOperation(operator).calculate(firstNumber, secondNumber);
    }

    private Double calculate(double x, double y) {
        return this.biFunction.apply(x, y);
    }

    private static Operation getOperation(String operator) {
        return Arrays.stream(values())
                .filter((operation) -> operation.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}