package calculator;

import calculator.operator.OperatorEnum;

public class Calculator {

    private final static String FORMULA_SEPARATION_KEYWROD = " ";

    private String[] formula;

    public Calculator(String input) {
        validateEmpty(input);
        this.formula = validateInvalidFormula(input);
    }

    public Double calculate() {
        double beforeNum = Double.parseDouble(formula[0]);

        for (int i = 1; i < this.formula.length - 1; i = i + 2) {
            OperatorEnum operator = OperatorEnum.getOperatorEnumFromKeyword(formula[i]);
            double afterNum = Double.parseDouble(formula[i + 1]);
            beforeNum = operator.calculate(beforeNum, afterNum);
        }
        return beforeNum;
    }

    private String[] validateInvalidFormula(String input) {
        String[] splitInput = input.split(FORMULA_SEPARATION_KEYWROD);
        for (int i = 1; i <= splitInput.length; i++) {
            if (i % 2 == 1) {
                checkNumber(splitInput[i - 1]);
                continue;
            }
            checkOperator(splitInput[i - 1]);
        }
        return splitInput;
    }

    private void checkOperator(String inputWord) {
        if (!OperatorEnum.isKeyword(inputWord)) {
            throw new IllegalArgumentException("수식 중 사칙연산 기호가 잘못되었습니다.");
        }
    }

    private void checkNumber(String inputWord) {
        try {
            double number = Double.parseDouble(inputWord);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("수식 중 숫자가 잘못되었습니다.");
        }
    }

    private void validateEmpty(String input) {
        if (input == null || "".equals(input.trim())) {
            throw new IllegalArgumentException("수식이 비워져 있습니다.");
        }
    }


}
