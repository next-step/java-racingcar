package calculator;

import calculator.operator.Operator;
import calculator.operator.OperatorFactory;

import java.util.Arrays;

public class Calculator {

    private final static String FORMULA_SEPARATION_KEYWROD = " ";
    private final static String[] OPERATOR_KEWORDS = {"+", "-", "*", "/"};

    private String[] formula;

    public Calculator(String input) {
        validationEmptyWithInput(input);
        this.formula = validationInvalidFormulaWithInput(input);
    }

    public Double calculate() {
        double beforeNum = Double.parseDouble(formula[0]);

        for (int i = 1; i < this.formula.length - 1; i=i+2) {
            Operator operator = getOperator(formula[i]);
            double afterNum = Double.parseDouble(formula[i+1]);
            beforeNum = operator.calculate(beforeNum, afterNum);
        }
        return beforeNum;
    }
    
    private Operator getOperator(String operatorString){
        Operator operator = OperatorFactory.getOperator(operatorString);
        if(operator == null){
            throw new IllegalArgumentException("수식 중 사칙연산 기호가 잘못되었습니다.");
        }
        return operator;
    }

    private String[] validationInvalidFormulaWithInput(String input) {
        String[] splitInput = input.split(FORMULA_SEPARATION_KEYWROD);
        for (int i = 1; i <= splitInput.length; i++) {
            if (i % 2 == 1) {
                isNumber(splitInput[i - 1]);
                continue;
            }
            isOperator(splitInput[i - 1]);
        }
        return splitInput;
    }

    private void isOperator(String inputWord) {
        if (!Arrays.stream(OPERATOR_KEWORDS).anyMatch(inputWord::equals)) {
            throw new IllegalArgumentException("수식 중 사칙연산 기호가 잘못되었습니다.");
        }
    }

    private void isNumber(String inputWord) {
        try {
            double number = Double.parseDouble(inputWord);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("수식 중 숫자가 잘못되었습니다.");
        }
    }

    private void validationEmptyWithInput(String input) {
        if (input == null || "".equals(input.trim())) {
            throw new IllegalArgumentException("수식이 비워져 있습니다.");
        }
    }


}
