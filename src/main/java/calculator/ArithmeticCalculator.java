package calculator;

import type.MessageFactory;

import java.util.Arrays;
import java.util.function.BinaryOperator;

enum ArithmeticCalculator {
    PLUS("+", (e1, e2) -> e1 + e2),
    MINUS("-", (e1, e2) -> e1 - e2),
    DIVISION("/", (e1, e2) -> e1 / e2),
    MULTI("*", (e1, e2) -> e1 * e2);

    private static final String DIVISION_ZERO_MESSAGE = "0으로 나눌 수 없습니다.";

    private final String operator;
    private final BinaryOperator<Double> binaryOperator;

    ArithmeticCalculator(final String operator, final BinaryOperator<Double> binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public static ArithmeticCalculator from(final String operator) {
        return Arrays.stream(ArithmeticCalculator.values())
                     .filter(value -> value.operator.equals(operator))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(MessageFactory.getInputErrorMessage()));
    }

    public Double operation(final Double e1, final Double e2) {
        if(isDivideByZero(e2)) {
            throw new IllegalArgumentException(DIVISION_ZERO_MESSAGE);
        }
        return binaryOperator.apply(e1, e2);
    }

    private boolean isDivideByZero(Double e2) {
        return operator.equals(DIVISION.operator) && e2 == 0;
    }
}
