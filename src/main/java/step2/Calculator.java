package step2;

public class Calculator {

    private Integer firstOperand;
    private Integer secondOperand;
    private String operator;

    // 계산
    public Integer calculate (String mathExpression) {

        if (mathExpression == null || mathExpression.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        resetStatus();

        String[] splitedMathExpression = mathExpression.split(" ");

        for (String expression : splitedMathExpression) {

            setting(expression);

            if (checkCalculable()) {
                firstOperand = OperatorType.searchOperation(operator)
                                            .calculate(firstOperand, secondOperand);
                secondOperand = null;
            }
        }

        return firstOperand;
    }

    // 계산 가능 여부 체크
    private boolean checkCalculable () {
        if (firstOperand != null && secondOperand != null && !"".equals(operator)) {
            return true;
        } else {
            return false;
        }
    }

    // 객체 상태 세팅
    private void setting (String expression) {
        try {
            if (firstOperand == null) {
                firstOperand = Integer.parseInt(expression);
            } else {
                secondOperand = Integer.parseInt(expression);
            }
        } catch(NumberFormatException e) {
            operator = expression;
        }
    }

    private void resetStatus() {
        firstOperand = null;
        secondOperand = null;
        operator = null;

    }
}
