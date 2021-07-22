package calc.type;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (operand1, operand2) -> operand1 + operand2),
    MINUS("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
    DIVIDE("/", (operand1, operand2) -> operand1 / operand2);

    private String operation;
    private BiFunction<Integer, Integer, Integer> resultFunction;

    Operation(String operation, BiFunction<Integer, Integer, Integer> resultFunction) {
        this.operation = operation;
        this.resultFunction = resultFunction;
    }

    public Integer calc(int operand1, int operand2) {
        return this.findByOperation(this.operation).resultFunction.apply(operand1, operand2);
    }

    public static Operation findByOperation(String operationStr) {
        return Arrays.stream(Operation.values())
                .filter(o -> o.operation.equals(operationStr))
                .findAny().orElseThrow(() -> new IllegalArgumentException("not support operation"));
    }

}
