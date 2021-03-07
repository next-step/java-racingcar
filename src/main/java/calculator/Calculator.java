package calculator;

import static calculator.Operator.getEnum;

public class Calculator {

    public int calculate(String formula) throws Exception {
        FormulaValidator validator = new FormulaValidator();
        validator.validate(formula);
        return this.executeCalculate(formula.split(CalculatorConstant.FORMULA_DELIMITER));
    }

    /**
     * 계산실행
     *  - 결과값을 정수로 한정
     */
    private int executeCalculate(String[] formula) throws Exception {
        int result = Integer.parseInt(formula[0]);
        for (int operatorIndex = 1; operatorIndex < formula.length-1; operatorIndex+=2) {
            result = getEnum(formula[operatorIndex]).operate(result, Integer.parseInt(formula[operatorIndex+1]));
        }
        return result;
    }
}
