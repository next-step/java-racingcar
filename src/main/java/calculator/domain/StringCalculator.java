package calculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StringCalculator {
    private final Map<String, Operator> operatorMap;

    public StringCalculator() {
        this.operatorMap = new HashMap<>();
        putOperator();
    }

    public double calculate(String operator, double num1, double num2) {
        return Optional.ofNullable(operatorMap.get(operator))
                .orElseThrow(() -> new IllegalArgumentException("잘못된 연산자입니다."))
                .calculate(num1, num2);
    }

    private void putOperator() {
        operatorMap.put("+", Operator.ADD);
        operatorMap.put("-", Operator.SUBTRACT);
        operatorMap.put("*", Operator.MULTIPLY);
        operatorMap.put("/", Operator.DIVIDE);
    }
}
