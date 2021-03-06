package calculator;

import common.utils.StringUtils;

public class Calculator {

    private final String FORMULA_DELIMITER = " ";

    public int calculate(String formula) {
        // input validation
        this.validateInput(formula);
        // executing calculation
        return this.executeCalculate(formula.split(FORMULA_DELIMITER));
    }

    /**
     * 입력값 검증
     *  - 입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw
     *  - 사칙연산 레이아웃 검증
     */
    public void validateInput(String formula) throws IllegalArgumentException {
        if(StringUtils.isEmpty(formula)) {
            throw new IllegalArgumentException("수식을 입력해 주세요");
        }
        if(!this.isValidOperationLayout(formula.split(FORMULA_DELIMITER))) {
            throw new IllegalArgumentException("수식의 구성이 올바르지 않습니다. 다시 입력해 주세요");
        }
    }

    private boolean isValidOperationLayout(String[] formula) {
        /*
        수식 길이검증
         - 수식은 홀수개의 인자로 구성되어야 한다.
         - 수식은 최소 3개 이상의 인자로 구성되어야 한다.
         */
        if(formula.length%2==0 || formula.length<3) {
            return false;
        }
        /*
        수식검증
         - 짝수번째 index 값은 숫자여야 한다.
         - 홀수번째 index 값은 사칙연산 기호여야 한다.
         */
        for (int i = 0; i < formula.length; i++) {
            if(i%2==0 && !this.isNumeric(formula[i])) {
                return false;
            }
            if(i%2!=0 && !this.isArithmeticOperator(formula[i])) {
                return false;
            }
        }
        return true;
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
}
