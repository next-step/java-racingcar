package calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    ADDITION("+") {
        public int operate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        public int operate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        public int operate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVISION("/") {
        public int operate(int operand1, int operand2) throws CalculateException {
            return operand1 / operand2;
        }
    };

    private final String OPERATION;
    private static final Map<String, Operation> operationMap = new HashMap<>();

    static {
        for (Operation operation : Operation.values()) {
            operationMap.put(operation.getValue(), operation);
        }
    }

    Operation(String operation) {
        OPERATION = operation;
    }

    public String getValue() {
        return OPERATION;
    }

    public static Operation getOperationByValue(String operationValue) {
        return operationMap.get(operationValue);
    }

    public static boolean isSupportedOperation(String input) {
        return operationMap.containsKey(input);
    }

    public abstract int operate(int operand1, int operand2) throws CalculateException;
}
