package stringcalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private static final Map<String, Operator> stringOperatorMap = new HashMap<>();

    static {
        for (Operator operator : Operator.values()) {
            stringOperatorMap.put(operator.value, operator);
        }
    }

    private final String value;
    private final BinaryOperator<Integer> calculate;

    Operator(String value, BinaryOperator<Integer> calculate) {
        this.value = value;
        this.calculate = calculate;
    }

    static Operator findBy(String value) {
        Operator operator = stringOperatorMap.get(value);

        if (operator == null) {
            throw new IllegalArgumentException("Unexpected value to find Operator '" + value + "'");
        }

        return operator;
    }

    Integer calculate(Integer num1, Integer num2) {
        return calculate.apply(num1, num2);
    }
}
