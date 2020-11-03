package calculator.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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

    private String sign;
    private BinaryOperator<Integer> expression;

    Operator(String sign, BinaryOperator<Integer> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    public static Operator build(String sign) {
        return Arrays.stream(Operator.values())
                .filter(v -> v.sign.equals(sign))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int x, int y) {
        return expression.apply(x, y);
    }


    private static final Set<String> OPERATOR_SIGNS_SET = new HashSet<>();
    static {
        Arrays.stream(Operator.values())
                .forEach(v -> OPERATOR_SIGNS_SET.add(v.sign));
    }

    public static boolean isOperator(String sign) {
        return OPERATOR_SIGNS_SET.contains(sign);
    }

    public static boolean isNotOperator(String sign) {
        return !OPERATOR_SIGNS_SET.contains(sign);
    }

}
