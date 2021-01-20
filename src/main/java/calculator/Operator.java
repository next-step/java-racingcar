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
            throw new IllegalArgumentException("");
        }
        return x / y;
    }),
    ;

    private static final Map<String, Operator> operations = new HashMap<>() {{
        put("+", PLUS);
        put("-", MINUS);
        put("*", MULTIPLY);
        put("/", DIVIDE);
    }};

    private final String sign;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String sign, final BiFunction<Double, Double, Double> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    public static double calculate(String sign, double x, double y) {
        Operator operator = operations.get(sign);
        if (operator == null) {
            throw new IllegalArgumentException("");
        }

        return operator.expression.apply(x, y);
    }
}
