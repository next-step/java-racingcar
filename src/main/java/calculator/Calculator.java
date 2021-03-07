package calculator;

import common.utils.StringUtils;

public class Calculator {

    private final String FORMULA_DELIMITER = " ";
    private final int FORMULA_MIN_LENGTH = 3;

    public int calculate(String formula) {
        this.validateInput(formula);
        return this.executeCalculate(formula.split(FORMULA_DELIMITER));
    }

    private void validateInput(String formula) throws IllegalArgumentException {
        if(StringUtils.isEmpty(formula)) {
            throw new IllegalArgumentException("수식을 입력해 주세요");
        }
        if(!this.isValidLength(formula.split(FORMULA_DELIMITER))) {
            throw new IllegalArgumentException("수식은 최소 2개의 수와 1개의 연산자로 구성되어야 합니다.");
        }
        try {
            this.validateOperationLayout(formula.split(FORMULA_DELIMITER));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("수식의 구성이 올바르지 않습니다. 다시 입력해 주세요");
        }

    }

    private boolean isValidLength(String[] formula) {
        return formula.length>=FORMULA_MIN_LENGTH;
    }

    private void validateOperationLayout(String[] formula) throws IllegalArgumentException {
        if(this.isEven(formula.length)) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
    }

    /**
     * 수식검증 - 홀수 index 값은 연산자여야 한다.
     */
    private void validateOddIndexPosition(int i, String target) throws IllegalArgumentException {
        if(!this.isEven(i) && !this.isArithmeticOperator(target)) {
            throw new IllegalArgumentException();
        }
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
        return "+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator) ;
    }

    /**
     * 계산실행
     *  - 결과값을 정수로 한정
     */
    private int executeCalculate(String[] formula) {

        int result = Integer.parseInt(formula[0]);

        for (int i = 1; i < formula.length-1; i+=2) {
            String operator = formula[i];
            switch (operator) {
                case "+":
                    result = result + Integer.parseInt(formula[i+1]);
                    break;
                case "-":
                    result = result - Integer.parseInt(formula[i+1]);
                    break;
                case "*":
                    result = result * Integer.parseInt(formula[i+1]);
                    break;
                case "/":
                    result = result / Integer.parseInt(formula[i+1]);
                    break;
            }
        }
        return result;
    }

    /**
     * 짝수판별
     */
    private boolean isEven(int a) {
        return a%2==0;
    }
}
