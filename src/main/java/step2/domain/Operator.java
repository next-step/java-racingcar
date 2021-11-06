package step2.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Operator::plus),
    SUBTRACT("-", Operator::subtract),
    MULTIPLY("*", Operator::multiply),
    DIVISION("/", Operator::division);

    private String value;

    private BiFunction<Number, Number, Integer> operation;

    Operator(String value, BiFunction<Number, Number, Integer> operation) {
        this.value = value;
        this.operation = operation;
    }

    public static Operator of(String operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.value.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 연산자입니다."));
    }

    public static boolean contains(String operator) {
        return Arrays.stream(Operator.values())
                .anyMatch(op -> op.value.equals(operator));
    }

    public int calculate(Number operand1, Number operand2) {
        return this.operation.apply(operand1, operand2);
    }

    private static int plus(Number operand1, Number operand2) {
        return operand1.plus(operand2);
    }

    private static int subtract(Number operand1, Number operand2) {
        return operand1.subtract(operand2);
    }

    private static int multiply(Number operand1, Number operand2) {
        return operand1.multiply(operand2);
    }

    private static int division(Number operand1, Number operand2) {
        return operand1.division(operand2);
    }
}
