package calculator;

import java.util.HashMap;
import java.util.Map;

public class CalculatorFactory {

    private Map<String, Calculator> calculatorMap = new HashMap<>();

    public CalculatorFactory() {
        calculatorMap.put("+", new Plus());
        calculatorMap.put("-", new Minus());
        calculatorMap.put("*", new Multiply());
        calculatorMap.put("/", new Divide());
    }

    public Calculator create(String operator) {
        Calculator calculator = calculatorMap.get(operator);

        if (calculator == null) {
            throw new IllegalArgumentException("Not Supported Operator.");
        }

        return calculator;
    }
}
