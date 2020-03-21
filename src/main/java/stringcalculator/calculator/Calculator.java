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

    private String operator;
    private BiFunction<Double, Double, Double> operation;

    private static Map<String, BiFunction<Double, Double, Double>> calculatorMap =
            Arrays.asList(Calculator.values()).stream().collect(Collectors.toMap(i -> i.operator, i -> i.operation));

    Calculator(String operator, BiFunction<Double, Double, Double> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static Double calculate(String operator, double leftNumber, double rightNumber) {
        return Calculator.calculatorMap
                .get(operator)
                .apply(leftNumber, rightNumber);
    }

}
