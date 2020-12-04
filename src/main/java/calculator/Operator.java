package calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    DIVIDE("/", (left, right) -> left / right),
    MULTIPLY("*", (left, right) -> left * right),
    ;

    private final String operator;
    private final BiFunction<Long, Long, Long> function;

    Operator(String operator, BiFunction<Long, Long, Long> function) {
        this.operator = operator;
        this.function = function;
    }

    public static long calculate(long left, long right, String source) {
        Operator operator = ofString(source);
        return operator.apply(left, right);
    }

    private static Operator ofString(String str) {
        for (Operator value : values()) {
            if (value.operator.equals(str)) {
                return value;
            }
        }
        throw new IllegalArgumentException("invalid operator");
    }

    private long apply(long left, long right) {
        return function.apply(left, right);
    }

}
