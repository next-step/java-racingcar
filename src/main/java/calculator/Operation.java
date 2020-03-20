package calculator;

import java.util.Arrays;
import java.util.List;

public enum Operation {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String OPERATION;
    private static final List<Operation> operations = Arrays.asList(Operation.values());

    Operation(String operation) {
        OPERATION = operation;
    }

    public String getValue() {
        return OPERATION;
    }

    public static boolean isSupportedOperation(String operation) {
        return operations.contains(Operation.valueOf(operation));
    }
}
