package step2;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private static final Map<String, Operation> OPERATIONS = new HashMap<>();

    static {
        for (Operator operator : Operator.values()) {
            OPERATIONS.put(operator.getOperatorType(), operator);
        }
    }

    public int calculate(final String inputData) {
        validateInputDataIsEmpty(inputData);

        String[] rowData = inputData.split(" ");

        int firstOperand = Integer.parseInt(rowData[0]);
        int calculateResult = 0;

        for (int i = 1; i < rowData.length - 1; i++) {
            if (validateIsCorrectOperatorType(rowData[i], i)) {
                Operation operator = OPERATIONS.get(rowData[i]);
                calculateResult = operator.calculate(firstOperand, Integer.parseInt(rowData[i + 1]));
                firstOperand = calculateResult;
            }
        }
        return calculateResult;

    }


    private boolean validateIsCorrectOperatorType(String operatorType, int index) {
        return index % 2 == 1 ? isHasExpression(operatorType) : false;
    }

    private boolean isHasExpression(String operatorType) {
        if (!OPERATIONS.containsKey(operatorType)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다");
        }
        return true;
    }

    private void validateInputDataIsEmpty(String inputData) {
        if (isNullOrEmpty(inputData) || isBlank(inputData)) {
            throw new IllegalArgumentException("입력값이 비어있습니다");
        }
    }

    private boolean isNullOrEmpty(String inputData) {
        return inputData == null || inputData.length() == 0;
    }

    private boolean isBlank(String inputData) {
        return inputData.trim().length() == 0;
    }
}
