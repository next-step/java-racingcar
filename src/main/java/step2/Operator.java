package step2;

import java.util.Arrays;

public enum Operator {
    PLUS("+", CalculatorNumber::plus),
    MINUS("-", CalculatorNumber::minus),
    TIMES("*", CalculatorNumber::times),
    DIVIDE_BY("/", CalculatorNumber::divideBy);

    private final String value;
    private final Operate operator;

    Operator(String value, Operate operator) {
        this.value = value;
        this.operator = operator;
    }

    public CalculatorNumber operate(CalculatorNumber first, CalculatorNumber second) {
        return operator.operate(first, second);
    }

    public static Operator findByValue(String value) {
        return Arrays.stream(Operator.values())
                .filter(e -> e.value.equals(value))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("사칙연산 기호가 아닙니다.")
                );
    }
}

@FunctionalInterface
interface Operate {
    CalculatorNumber operate(CalculatorNumber firstOperand, CalculatorNumber secondOperand);
}
