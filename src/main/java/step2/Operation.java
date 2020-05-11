package step2;

import java.util.Arrays;
import java.util.function.Function;

public enum Operation {
    PLUS("+", Calculator::plus),
    MINUS("-", Calculator::minus),
    MULTIPLE("*", Calculator::multiple),
    DIVIDE("/", Calculator::divide);

    Operation(String operation, Function<Calculator, Integer> expression) {
        this.operation = operation;
        this.expression = expression;
    }

    private final String operation;
    private final Function<Calculator, Integer> expression;

    public String getOperation() {
        return operation;
    }

    public static int calculate(String operation, Calculator calculator) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.getOperation().equals(operation))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."))
                .expression
                .apply(calculator);
    }
}
