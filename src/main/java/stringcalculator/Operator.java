package stringcalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private static final Map<String, Operator> stringOperatorMap = new HashMap<>();

    static {
        for (Operator operator : Operator.values()) {
            stringOperatorMap.put(operator.strValue, operator);
        }
    }

    private final String strValue;
    private final BiFunction<Integer, Integer, Integer> calculate;

    Operator(String strValue, BiFunction<Integer, Integer, Integer> calculate) {
        this.strValue = strValue;
        this.calculate = calculate;
    }

    private static Operator findBy(String strValue) {
        Operator operator = stringOperatorMap.get(strValue);

        if (operator == null) {
            throw new IllegalArgumentException("Unexpected strValue to find Operator '" + strValue + "'");
        }

        return operator;
    }

    private Integer calculate(Integer num1, Integer num2) {
        return calculate.apply(num1, num2);
    }
}
