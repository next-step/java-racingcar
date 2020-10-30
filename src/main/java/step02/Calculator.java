package step02;

import exception.EmptyException;
import exception.InValidOperatorException;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private static final Map<String, Operation> OPERATIONS = new HashMap<>();

    static {
        for (Operator operator : Operator.values()) {
            OPERATIONS.put(operator.getOperatorType(), operator);
        }
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.length() == 0;
    }

    private boolean isBlank(String input) {
        return input.trim().length() == 0;
    }

    private void validateInputHasContents(String input) {
        if (isNullOrEmpty(input) || isBlank(input)) {
            throw new EmptyException();
        }
    }

    private void validateOperatorType(String operatorType) {
        if (!OPERATIONS.containsKey(operatorType))
            throw new InValidOperatorException();
    }

    public int calculate(final String input) {

        validateInputHasContents(input);

        String[] rowData = input.split(" ");

        int calculateResult = Integer.parseInt(rowData[0]);

        for (int i = 1; i < rowData.length - 1; i += 2) {
            String operatorType = rowData[i];

            validateOperatorType(operatorType);

            int rightOperand = Integer.parseInt(rowData[i + 1]);
            int leftOperand = calculateResult;

            Operation operator = OPERATIONS.get(operatorType);
            calculateResult = operator.calculate(leftOperand, rightOperand);
        }

        return calculateResult;
    }
}
