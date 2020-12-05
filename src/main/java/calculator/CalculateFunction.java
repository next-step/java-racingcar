package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class CalculateFunction {
    private static final String DIVIDE = "/";
    private Map<String, BiFunction<Integer, Integer, Integer>> calculateFunctionMap;

    public CalculateFunction() {
        calculateFunctionMap = new HashMap<>();
        calculateFunctionMap.put("+", (x, y) -> x + y);
        calculateFunctionMap.put("-", (x, y) -> x - y);
        calculateFunctionMap.put("*", (x, y) -> x * y);
        calculateFunctionMap.put("/", (x, y) -> x / y);
    }

    public int calculate(String expression, int x, int y) {
        validate(expression, y);
        return calculateFunctionMap.get(expression)
                .apply(x, y);
    }

    private void validate(String expression, int y) {
        if (!calculateFunctionMap.containsKey(expression)) {
            throw new IllegalArgumentException("잘못된 연산자입니다.");
        }

        if (DIVIDE.equals(expression) && y == 0) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다.");
        }
    }
}
