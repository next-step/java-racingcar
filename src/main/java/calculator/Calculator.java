package calculator;

public class Calculator {

    private String[] operandAndOperators;
    private double result;
    private static final String operandRegex = "^[0-9]*$";
    private static final String operatorRegex = "^[\\+\\-\\*\\/]{1}$";

    public Calculator(String[] operandAndOperators) {
        this.operandAndOperators = operandAndOperators;
    }

    /**
     * 피연산자가 숫자인지 검증
     */
    public static void validateOperand(String operand) {
        if (!operand.matches(operandRegex)) {
            throw new IllegalArgumentException("피연산자가 숫자가 아님");
        }
    }

    /**
     * 연산자가 사칙연산인지 체크 [+, -, *, /]
     */
    public static void validateOperator(String operator) {
        if (!operator.matches(operatorRegex)) {
            throw new IllegalArgumentException("연산자가 사칙연산이 아님");
        }
    }

    public void calculateUserInput() {
        for (String x : operandAndOperators) {

        }
    }

    /**
     * 피연산자 2개, 연산자 1개를 받아 계산후 리턴
     */
    public double calculate(String operand1, String operand2, String operator) {
        validateOperand(operand1);
        validateOperand(operand2);
        validateOperator(operator);

//        if (ArithmeticOperation.PLUS.isEqusls(operator) {
//
//        }
//        if (ArithmeticOperation.MINUS.isEqusls(operator) {
//
//        }
//        if (ArithmeticOperation.MULTIPLICATION.isEqusls(operator) {
//
//        }
//        if (ArithmeticOperation.DIVISION.isEqusls(operator) {
//
//        }

        return 0;
    }

    private double plus(double operand1, double operand2) {
        return operand1 + operand2;
    }

    private double minus(double operand1, double operand2) {
        return operand1 - operand2;
    }

    private double multiplication(double operand1, double operand2) {
        return operand1 * operand2;
    }

    private double division(double operand1, double operand2) {
        return operand1 / operand2;
    }
}
