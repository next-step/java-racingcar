package calculator;

import java.util.HashMap;

public class CalculatorFactory {

    private HashMap<String, Calculator> map = new HashMap<>();

    public CalculatorFactory() {
        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> a - b);
        map.put("/", (a, b) -> a / b);
        map.put("*", (a, b) -> a * b);
    }

    public Calculator createCalculator(String operator) {
        Calculator calculator = map.get(operator);

        if(calculator == null) {
            throw new IllegalArgumentException("잘못된 수식입니다. 다시 입력해주세요.");
        }
        return calculator;
    }
}
