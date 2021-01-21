package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        if (y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return x / y;
    }),
    ;

    private static final Map<String, Operator> operators = new HashMap<>();

    static {
        for (Operator operator : values()) {
            operators.put(operator.sign, operator);
        }
    }

    private final String sign;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String sign, final BiFunction<Double, Double, Double> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    public static double calculate(String sign, double x, double y) {
        Operator operator = operators.get(sign);
        if (operator == null || sign.isBlank()) {
            throw new IllegalArgumentException("유효한 사칙 연산자가 아닙니다.");
        }
        return operator.expression.apply(x, y);
    }
}
