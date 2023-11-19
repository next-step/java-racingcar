package calculator.domain;

import error.CustomError;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.DoubleBinaryOperator;

public enum OperationType {
    PLUS("+", Double::sum),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String type;
    private final DoubleBinaryOperator operation;

    OperationType(String type, DoubleBinaryOperator operation) {
        this.type = type;
        this.operation = operation;
    }

    public static OperationType getOperationType(String operationType) {
        return Arrays.stream(values())
                     .filter(type -> Objects.equals(operationType, type.getType()))
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException(CustomError.NOT_EXIST_SYMBOL_ERROR.getErrorContent()));
    }

    public String getType() {
        return type;
    }

    public double getOperationResult(double left, double right) {
        return operation.applyAsDouble(left, right);
    }
}
