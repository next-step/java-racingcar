package calc.type;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String operation;
    private BiFunction<Integer, Integer, Integer> resultFunction;

    Operation(String operation, BiFunction<Integer, Integer, Integer> resultFunction) {
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
