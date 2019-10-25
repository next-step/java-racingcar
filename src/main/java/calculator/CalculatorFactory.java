package calculator;

import java.util.HashMap;

public class CalculatorFactory {

    private HashMap<String, Calculator> map = new HashMap<>();

    public CalculatorFactory() {
        map.put("+", new Addition());
        map.put("-", new Subtraction());
        map.put("/", new Division());
        map.put("*", new Multiplication());
    }

    public Calculator createCalculator(String operator) {
        Calculator calculator = map.get(operator);
        if(calculator == null) {
            throw new IllegalArgumentException("잘못된 수식입니다. 다시 입력해주세요.");
        }
        return calculator;

    }
}
