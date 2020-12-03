package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    ADDITION("+", (num1, num2) -> (num1 + num2)),
    SUBTRACTION("-", (num1, num2) -> (num1 - num2)),
    MULTIPLICATION("*", (num1, num2) -> (num1 * num2)),
    DIVISION("/", (num1, num2) -> (num1 / num2));

    private String operator;
    private BiFunction<Long, Long, Long> expression;

    Operation(String operator, BiFunction<Long, Long, Long> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operation of(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(operator + " is not operator"));
    }

    public Long calculate(Long num1, Long num2) {
        return expression.apply(num1, num2);
    }
}
