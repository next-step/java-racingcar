package calculator;

import java.util.HashMap;
import java.util.Map;

public class CalculatorSelector {
    private static Map<String, Calculator> calculatorMap = new HashMap<>();

    static {
        calculatorMap.put("+", Calculator.ADD);
        calculatorMap.put("-", Calculator.SUBTRACT);
        calculatorMap.put("*", Calculator.MULTIPLY);
        calculatorMap.put("/", Calculator.DIVIDE);
    }

    public static Calculator getCalculator(String operator) {
        return calculatorMap.get(operator);
    }

}
