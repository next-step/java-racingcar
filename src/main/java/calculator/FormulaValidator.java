package calculator;

import common.utils.StringUtils;

public class FormulaValidator {

    private static final int FORMULA_MIN_LENGTH = 3;

    public void validate(String formula) throws IllegalArgumentException {
        this.validateEmpty(formula);
        this.validateLength(formula.split(CalculatorConstant.FORMULA_DELIMITER));
        this.validateOperationLayout(formula.split(CalculatorConstant.FORMULA_DELIMITER));
    }

    private void validateEmpty(String formula) {
        if(StringUtils.isEmpty(formula)) {
            throw new IllegalArgumentException("수식을 입력해 주세요");
        }
    }

    private void validateLength(String[] formula) {
        if(!this.isValidLength(formula)) {
            throw new IllegalArgumentException("수식은 최소 2개의 수와 1개의 연산자로 구성되어야 합니다.");
        }
    }

    private boolean isValidLength(String[] formula) {
        return formula.length>=FORMULA_MIN_LENGTH;
    }

    private void validateOperationLayout(String[] formula) throws IllegalArgumentException {
        if(this.isEven(formula.length)) {
            throw new IllegalArgumentException("수식은 홀수개의 인자로 구성되어야 합니다. 다시 입력해 주세요");
        }

        for (int i = 0; i < formula.length; i++) {
            validateEvenIndexPosition(i, formula[i]);
            validateOddIndexPosition(i, formula[i]);
        }
    }

    /**
     * 수식검증 - 짝수 index 값은 숫자여야 한다.
     */
    private void validateEvenIndexPosition(int i, String target) throws IllegalArgumentException {
        if(this.isEven(i) && !this.isNumeric(target)) {
            throw new IllegalArgumentException("수식의 짝수번째 인자는 숫자여야 합니다.");
        }
    }

    /**
     * 수식검증 - 홀수 index 값은 연산자여야 한다.
     */
    private void validateOddIndexPosition(int i, String target) throws IllegalArgumentException {
        if(!this.isEven(i) && !this.isArithmeticOperator(target)) {
            throw new IllegalArgumentException("수식의 홀수번째 인자는 연산자여야 합니다.");
        }
    }

    /**
     * 짝수판별
     */
    private boolean isEven(int a) {
        return a%2==0;
    }

    /**
     * 입력값이 숫자인지 판별
     */
    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * 사칙연산 연산자인지 판별
     */
    private boolean isArithmeticOperator(String operator) {
        try {
            Operator.getEnum(operator);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
