package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public enum Operator {
    ADD((num1, num2) -> num1 + num2),
    SUBTRACT((num1, num2) -> num1 - num2),
    MULTIPLY((num1, num2) -> num1 * num2),
    DIVIDE((num1, num2) -> num1 / num2);

    private BinaryOperator<Integer> expression;
    private final static Map<String, Operator> OPERATOR;

    Operator(BinaryOperator<Integer> expression) {
        this.expression = expression;
    }

    static {
        OPERATOR = new HashMap<>();
        OPERATOR.put("+", Operator.ADD);
        OPERATOR.put("-", Operator.SUBTRACT);
        OPERATOR.put("*", Operator.MULTIPLY);
        OPERATOR.put("/", Operator.DIVIDE);
    }

    public static boolean containsKey(String operator) {
        return OPERATOR.containsKey(operator);
    }

    public int calculate(int result, int value) {
        return expression.apply(result, value);
    }

    public static Operator calculateOfOperator(String operatorInput) {
        return OPERATOR.get(operatorInput);
    }
}
