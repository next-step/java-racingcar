package stringcalculator;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum OperatorType {
    plus("+", (n1, n2) -> n1 + n2),
    minus("-", (n1, n2) -> n1 - n2),
    multiply("*", (n1, n2) -> n1 * n2),
    divide("/", (n1, n2) -> n1 / n2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;
    private final static Map<String, OperatorType> calculateMap;

    static {
        calculateMap = Arrays.stream(OperatorType.values())
                .collect(Collectors.toMap(OperatorType::getOperator, o->o));
    }

    OperatorType(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public String getOperator() {
        return operator;
    }

    public int calculate(int n1, int n2) {
        return expression.apply(n1, n2);
    }

    public static OperatorType getOperatorType(String key) {
        if (!calculateMap.containsKey(key)) {
            throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
        }
        return calculateMap.get(key);
    }


}
