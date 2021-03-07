package study.step2;

import study.step2.constant.CalculatorConst;

public enum Calculator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    private final String operator;

    Calculator(String operator) {
        this.operator = operator;
    }

    private String getOperator() {
        return operator;
    }

    public static int operate(String operator, int number1, int number2) {
        if(operator.equals(PLUS.getOperator())) {
            return number1 + number2;
        }
        if(operator.equals(MINUS.getOperator())) {
            return number1 - number2;
        }
        if(operator.equals(MULTIPLE.getOperator())){
            return number1 * number2;
        }
        if(operator.equals(DIVIDE.getOperator())) {
            return number1 / number2;
        }

        throw new IllegalArgumentException(CalculatorConst.MESSAGE_NOT_OPERATOR);
    }
}
