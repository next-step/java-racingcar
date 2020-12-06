package calculator.operaor;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    private static final Map<String, Operator> operatorMap = new HashMap<>();

    static {
        operatorMap.put("+", new Add());
        operatorMap.put("-", new Minus());
        operatorMap.put("*", new Multiply());
        operatorMap.put("/", new Division());
    }

    public static Operator getOperator(String operatorKey) {
        return operatorMap.get(operatorKey);
    }
}
