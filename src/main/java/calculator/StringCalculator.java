package calculator;

import common.CommonConstant;

public class StringCalculator {

    private String valueToCalculate;
    private InputValidator inputValidator;

    public StringCalculator(String valueToCalculate) {
        inputValidator = new InputValidator();
        this.valueToCalculate = inputValidator.validateValueToCalulate(valueToCalculate);
    }

    public int calculate() {
        String[] values = valueToCalculate.split(CommonConstant.EMPTY_SPACE_CHARACTER);
        int leftValue = 0;
        int rightValue = 0;
        String operationSymbol;
        int maxI = values.length;
        for (int i = 0; i < maxI; i++) {
            if (i == 0) {
                leftValue = Integer.parseInt(values[i]);
            }
            if (i % 2 == 1) {
                operationSymbol = inputValidator.validateOperationSymbol(values[i]);
                rightValue = Integer.parseInt(values[i + 1]);
                leftValue = Calculator.calculators.get(operationSymbol).calculate(leftValue, rightValue);
            }
        }
        return leftValue;
    }

}
