package calculator;

import common.CommonConstant;

public class InputValidator {

    private final String CHECK_OPERATION_SYMBOL = "사칙연산 기호를 확인하세요.";

    public String valueToCalulateValidate(String valueToCalculate) throws IllegalArgumentException {
        if (valueToCalculate == null || CommonConstant.EMPTY_CHARACTER.equals(valueToCalculate.trim())) {
            throw new IllegalArgumentException(CommonConstant.CHECK_INPUT_VALUE);
        }
        return valueToCalculate;
    }

    public String operationSymbolValidate(String operationSymbol) throws IllegalArgumentException {
        if (!CommonConstant.CALCULATE_ADD_SYMBOL.equals(operationSymbol) && !CommonConstant.CALCULATE_SUBTRACT_SYMBOL.equals(operationSymbol) && !CommonConstant.CALCULATE_MULTIPLE_SYMBOL.equals(operationSymbol) && !CommonConstant.CALCULATE_DIVISION_SYMBOL.equals(operationSymbol)) {
            throw new IllegalArgumentException(CHECK_OPERATION_SYMBOL);
        }
        return operationSymbol;
    }
}
