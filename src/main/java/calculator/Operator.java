package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", Number::plus),
    MINUS("-", Number::minus),
    TIMES("*", Number::times),
    DIVIDED_BY("/", Number::dividedBy);

    private final String operator;
    private final BiFunction<Number, Number, Number> expression;

    Operator(String operator, BiFunction<Number, Number, Number> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public Number calculate(Number first, Number second) {
        return expression.apply(first, second);
    }

    public static Operator from(String operator) {
        return Arrays.stream(values())
                .filter(o -> operator.equals(o.operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

}
