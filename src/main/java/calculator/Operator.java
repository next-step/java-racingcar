package calculator;

import calculator.exception.NotSupportedOperatorException;

import java.util.Arrays;

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
                .findFirst().orElseThrow(NotSupportedOperatorException::new);
    }

    public boolean equals(String value) {
        return this.value.equals(value);
    }

    public MyNumber calculate(MyNumber first, MyNumber second) {
        return calculable.apply(first, second);
    }
}
