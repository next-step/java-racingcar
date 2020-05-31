package calculator;

import java.util.HashMap;
import java.util.Map;

public class CalculatorSelector {
    private static Map<String, Calculator> CalculatorMap = new HashMap<>();

    static {
        CalculatorMap.put("+", Calculator.ADD);
        CalculatorMap.put("-", Calculator.SUBTRACT);
        CalculatorMap.put("*", Calculator.MULTIPLY);
        CalculatorMap.put("/", Calculator.DIVIDE);
    }

    public static Calculator getCalculator(String operator) {
        return CalculatorMap.get(operator);
    }

}
