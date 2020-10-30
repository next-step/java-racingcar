package step02;

import exception.EmptyException;

public class Calculator {

    private boolean isNull(String input) {
        return input == null;
    }

    private boolean isBlank(String input) {
        return input.trim().length() == 0;
    }

    private void validateInputHasContents(String input) {
        if (isNull(input) || isBlank(input)) {
            throw new EmptyException();
        }
    }

    public int calculate(final String input) {
        validateInputHasContents(input);
        String[] rowData = input.split(" ");
        int calculateResult = Integer.parseInt(rowData[0]);
        for (int i = 1; i < rowData.length - 1; i += 2) {
            calculateResult = Operator.executeOf(
                    rowData[i],
                    calculateResult,
                    Integer.parseInt(rowData[i + 1])
            );
        }
        return calculateResult;
    }
}
