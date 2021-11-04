package calculator;

import java.util.Arrays;

/**
 * Created by owen.ny on 2021/11/03.
 */
public enum Operator {
    ADDITION("+", MyNumber::plus),
    SUBSTITUTION("-", MyNumber::minus),
    MULTIPLICATION("*", MyNumber::multiply),
    DIVISION("/", MyNumber::divide);

    private final String value;
    private final Calculable calculable;

    Operator(String value, Calculable calculable) {
        this.value = value;
        this.calculable = calculable;
    }

    public static Operator of(String value) {
        return Arrays.stream(values()).filter(it -> it.equals(value))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다"));
    }

    public boolean equals(String value) {
        return this.value.equals(value);
    }

    public MyNumber calculate(MyNumber first, MyNumber second) {
        return calculable.apply(first, second);
    }
}
