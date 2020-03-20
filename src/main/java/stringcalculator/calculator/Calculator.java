package stringcalculator.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Calculator {
    ADDITION((leftNumber, rightNumber) -> leftNumber + rightNumber),
    SUBTRACTION((leftNumber, rightNumber) -> leftNumber - rightNumber),
    MULTIPLICATION((leftNumber, rightNumber) -> leftNumber * rightNumber),
    DIVISION((leftNumber, rightNumber) -> leftNumber / rightNumber);

    private BiFunction<Double, Double, Double> operation;

    Calculator(BiFunction<Double, Double, Double> operation) {
        this.operation = operation;
    }

    private static final Map<String, Calculator> OPERATORS;
    static {
        OPERATORS = new HashMap<>();
        OPERATORS.put("+", Calculator.ADDITION);
        OPERATORS.put("-", Calculator.SUBTRACTION);
        OPERATORS.put("*", Calculator.MULTIPLICATION);
        OPERATORS.put("/", Calculator.DIVISION);
    }

    public static Calculator getOperation(String operation) {
        return OPERATORS.get(operation);
    }

    public double calculate(Double leftNumber, Double rightNumber) {
        return operation.apply(leftNumber, rightNumber);
    }
}
