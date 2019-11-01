package calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    enum Operator {
        ADD("+", (leftValue, rightValue) -> leftValue + rightValue),
        SUBTRACT("-", (leftValue, rightValue) -> leftValue - rightValue),
        MULTIPLY("*", (leftValue, rightValue) -> leftValue * rightValue),
        DIVISION("/", (leftValue, rightValue) -> leftValue / rightValue);

        private String operationSymbol;
        private BiFunction<Integer, Integer, Integer> calculation;

        Operator(String operationSymbol, BiFunction<Integer, Integer, Integer> calculation) {
            this.operationSymbol = operationSymbol;
            this.calculation = calculation;
        }

        public Integer calculate(Integer leftValue, Integer rightValue) {
            return this.calculation.apply(leftValue, rightValue);
        }
    }

    public static Map<String, Operator> calculators = new HashMap<>();

    static {
        for (Operator operartor : Operator.values()) {
            calculators.put(operartor.operationSymbol, operartor);
        }
    }
}
