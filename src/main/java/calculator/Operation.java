package calculator;

import java.util.Arrays;
import java.util.function.ToLongBiFunction;

public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private String view;
    private ToLongBiFunction<Long, Long> function;

    Operation(String display, ToLongBiFunction<Long, Long> function) {
        this.view = display;
        this.function = function;
    }

    public String getView() {
        return view;
    }
    public long calculate(long x, long y) {
        return function.applyAsLong(x, y);
    }

    public static Operation findOperation(String operation) {
        return Arrays.stream(Operation.values())
                .filter(op -> op.getView().equals(operation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
    }
}
