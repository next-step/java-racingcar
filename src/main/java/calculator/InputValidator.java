package calculator;

import common.CommonConstant;

public class InputValidator {

    public String valueToCalulateValidate(String valueToCalculate) throws IllegalArgumentException {
        if (valueToCalculate == null || "".equals(valueToCalculate.trim())) {
            throw new IllegalArgumentException(CommonConstant.CHECK_INPUT_VALUE);
        }
        return valueToCalculate;
    }

    public String operationSymbolValidate(String operationSymbol) throws IllegalArgumentException {
        if (!"+".equals(operationSymbol) && !"-".equals(operationSymbol) && !"*".equals(operationSymbol) && !"/".equals(operationSymbol)) {
            throw new IllegalArgumentException(CommonConstant.CHECK_OPERATION_SYMBOL);
        }
        return operationSymbol;
    }
}
