package calculator.application;

import calculator.domain.OperationType;

public class CalculatorService {
    private static final String DELIMITER = " ";

    public static double calculate(String input) {
        String[] values = input.split(DELIMITER);
        double result = Double.parseDouble(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            String operator = values[i];
            int right = Integer.parseInt(values[i + 1]);
            result = OperationType.getOperationType(operator)
                                  .getOperationResult(result, right);
        }
        return result;
    }
}

