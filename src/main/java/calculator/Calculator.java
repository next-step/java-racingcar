package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Calculator {

    ADD("+", (leftValue, rightValue) -> leftValue + rightValue),
    SUBTRACT("-", (leftValue, rightValue) -> leftValue - rightValue),
    MULTIPLY("*", (leftValue, rightValue) -> leftValue * rightValue),
    DIVISION("/", (leftValue, rightValue) -> leftValue / rightValue);

    private String operationSymbol;
    private BiFunction<Integer, Integer, Integer> operation;

    Calculator(String operationSymbol, BiFunction<Integer, Integer, Integer> operation) {
        this.operationSymbol = operationSymbol;
        this.operation = operation;
    }

    public static Map<String, Calculator> calculators = new HashMap<>();

    static {
        for (Calculator calculator : Calculator.values()) {
            calculators.put(calculator.operationSymbol, calculator);
        }
    }

    public static int execute (String operationSymbol, Integer leftValue, Integer rightValue) {
        return calculators.get(operationSymbol).calculate(leftValue, rightValue);
    }

    public Integer calculate(Integer leftValue, Integer rightValue) {
        return this.operation.apply(leftValue, rightValue);
    }
}
