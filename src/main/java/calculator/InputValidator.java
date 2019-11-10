package calculator;

public class InputValidator {

    private static final String CHECK_OPERATION_SYMBOL = "사칙연산 기호를 확인하세요.";
    private static final String CALCULATE_ADD_SYMBOL = "+";
    private static final String CALCULATE_SUBTRACT_SYMBOL = "-";
    private static final String CALCULATE_MULTIPLE_SYMBOL = "*";
    private static final String CALCULATE_DIVISION_SYMBOL = "/";
    private static final String EMPTY_CHARACTER = "";
    private static final String CHECK_INPUT_VALUE = "입력한 값을 확인하세요.";

    public String validateValueToCalulate(String valueToCalculate) throws IllegalArgumentException {
        if (valueToCalculate == null || EMPTY_CHARACTER.equals(valueToCalculate.trim())) {
            throw new IllegalArgumentException(CHECK_INPUT_VALUE);
        }
        return valueToCalculate;
    }

    public String validateOperationSymbol(String operationSymbol) throws IllegalArgumentException {
        if (!CALCULATE_ADD_SYMBOL.equals(operationSymbol) &&
            !CALCULATE_SUBTRACT_SYMBOL.equals(operationSymbol) &&
            !CALCULATE_MULTIPLE_SYMBOL.equals(operationSymbol) &&
            !CALCULATE_DIVISION_SYMBOL.equals(operationSymbol)) {
            throw new IllegalArgumentException(CHECK_OPERATION_SYMBOL);
        }
        return operationSymbol;
    }
}
