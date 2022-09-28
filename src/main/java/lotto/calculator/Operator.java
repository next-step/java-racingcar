package lotto.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", Number::add),
    SUBTRACT("-", Number::subtract),
    MULTIPLY("*", Number::multiply),
    DIVIDE("/", Number::divide);

    private static final String UNSUPPORTED_OPERATOR_EXCEPTION_MESSAGE = "사칙연산 기호가 아닙니다";

    private final String operator;
    private final BiFunction<Number, Number, Number> operate;

    Operator(String operator, BiFunction<Number, Number, Number> operate) {
        this.operator = operator;
        this.operate = operate;
    }

    public static Operator of(String value) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(UNSUPPORTED_OPERATOR_EXCEPTION_MESSAGE));
    }

    public Number operate(Number left, Number right) {
        return operate.apply(left, right);
    }
}
