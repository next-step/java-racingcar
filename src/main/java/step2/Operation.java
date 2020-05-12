package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLE("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    Operation(String operation, BiFunction<Integer, Integer, Integer> expression) {
        this.operation = operation;
        this.expression = expression;
    }

    private final String operation;
    private final BiFunction<Integer, Integer, Integer> expression;

    public String getOperation() {
        return operation;
    }

    public static int calculate(String operation, int num1, int num2) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getOperation().equals(operation))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."))
                .expression
                .apply(num1, num2);
    }
}
