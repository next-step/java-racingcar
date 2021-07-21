package calc.type;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (a, b) -> (int) a + (int) b),
    MINUS("-", (a, b) -> (int) a - (int) b),
    MULTIPLY("*", (a, b) -> (int) a * (int) b),
    DIVIDE("/", (a, b) -> (int) a / (int) b);

    private String operation;
    private BiFunction<Integer, Integer, Integer> resultFunction;

    Operation(String operation, BiFunction resultFunction) {
        this.operation = operation;
        this.resultFunction = resultFunction;
    }

    public Integer calc(int a, int b) {
        return this.findByOperation(this.operation).resultFunction.apply(a, b);
    }

    public static Operation findByOperation(String operationStr) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.operation.equals(operationStr))
                .findAny().orElseThrow(() -> new IllegalArgumentException("not support operation"));
    }

}
