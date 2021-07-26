package calculator;

import java.util.Arrays;
import java.util.function.ToLongBiFunction;

public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private String operator;
    private ToLongBiFunction<Long, Long> function;

    Operation(String operator, ToLongBiFunction<Long, Long> function) {
        this.operator = operator;
        this.function = function;
    }

    public static Operation findOperation(String operation) {
        return Arrays.stream(Operation.values())
                .filter(op -> op.getOperator().equals(operation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
    }

    public long calculate(long x, long y) {
        if (operator.equals("/") && y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return function.applyAsLong(x, y);
    }

    public String getOperator() {
        return operator;
    }
}
