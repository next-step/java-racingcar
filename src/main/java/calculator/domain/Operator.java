package calculator.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public enum Operator {

    ADD("+", Math::addExact),
    SUBTRACT("-", Math::subtractExact),
    MULTIPLY("*", Math::multiplyExact),
    DIVIDE("/", (x, y) -> {
        if (y == 0)
            throw new IllegalArgumentException();
        return x / y;
    });

    private static final String NOT_DEFINITION_ERROR = "연산자가 정의되지 않은 Operator입니다.";
    private static final Map<String, Operator> OPERATOR_SIGNS_MAP = new HashMap<>();

    static {
        for (Operator operator : Operator.values()) {
            OPERATOR_SIGNS_MAP.put(operator.sign, operator);
        }
    }

    private String sign;
    private BinaryOperator<Integer> expression;

    Operator(String sign, BinaryOperator<Integer> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    public static Operator build(String sign) {
        Operator operator = OPERATOR_SIGNS_MAP.get(sign);
        if (operator == null) {
            throw new IllegalArgumentException(NOT_DEFINITION_ERROR);
        }
        return operator;
    }

    public int calculate(int x, int y) {
        return expression.apply(x, y);
    }

    public static boolean isOperator(String sign) {
        return OPERATOR_SIGNS_MAP.containsKey(sign);
    }

    public static boolean isNotOperator(String sign) {
        return !OPERATOR_SIGNS_MAP.containsKey(sign);
    }

}
