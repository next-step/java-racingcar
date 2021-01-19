package caculator;

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

    Operator(final String sign, final BiFunction<Integer, Integer, Integer> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    public static int calculate(String operator, int x, int y) {
        return getOperator(operator).expression.apply(x, y);
    }

    private static Operator getOperator(final String sign) {
        if (sign.equals("+")) {
            return PLUS;
        } else if (sign.equals("-")) {
            return MINUS;
        } else if (sign.equals("*")) {
            return MULTIPLY;
        } else if (sign.equals("/")) {
            return DIVIDE;
        } else {
            throw new IllegalArgumentException("");
        }
    }
}
