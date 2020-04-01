package calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    ADDITION("+") {
        @Override
        public int operate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int operate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int operate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVISION("/") {
        @Override
        public int operate(int operand1, int operand2) throws CalculateException {
            if (operand2 == 0) {
                throw new CalculateException();
            }

            return operand1 / operand2;
        }
    };

    private final String operation;
    private static final Map<String, Operation> operationMap = new HashMap<>();

    static {
        for (Operation operation : Operation.values()) {
            operationMap.put(operation.getValue(), operation);
        }
    }

    Operation(String operation) {
        this.operation = operation;
    }

    public String getValue() {
        return operation;
    }

    public static Operation getOperationByValue(String operationValue) {
        return operationMap.get(operationValue);
    }

    public static boolean isSupportedOperation(String input) {
        return operationMap.containsKey(input);
    }

    public abstract int operate(int operand1, int operand2) throws CalculateException;
}
