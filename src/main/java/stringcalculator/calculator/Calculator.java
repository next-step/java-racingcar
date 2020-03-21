package stringcalculator.calculator;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum Calculator {
    ADDITION("+", (leftNumber, rightNumber) -> leftNumber + rightNumber),
    SUBTRACTION("-", (leftNumber, rightNumber) -> leftNumber - rightNumber),
    MULTIPLICATION("*", (leftNumber, rightNumber) -> leftNumber * rightNumber),
    DIVISION("/", (leftNumber, rightNumber) -> leftNumber / rightNumber);

    private static Map<String, BiFunction<Double, Double, Double>> operators =
            Arrays.asList(Calculator.values())
                    .stream()
                    .collect(Collectors
                            .toMap(i -> i.operator, i -> i.operation));
    private String operator;
    private BiFunction<Double, Double, Double> operation;

    Calculator(String operator, BiFunction<Double, Double, Double> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static Double calculate(String operator, double leftNumber, double rightNumber) {
        return Calculator.operators
                .get(operator)
                .apply(leftNumber, rightNumber);
    }

}
