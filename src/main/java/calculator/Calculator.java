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

    public double calculateUserInput() {
        double result = Double.parseDouble(operandAndOperators[0]);

        for (int i = 1; i < operandAndOperators.length; i += 2) {
            result = calculate(result, Double.parseDouble(operandAndOperators[i + 1]), operandAndOperators[i]);
        }

        return result;
    }

    /**
     * 피연산자 2개, 연산자 1개를 받아 계산후 리턴
     */
    public static double calculate(double operand1, double operand2, String operator) {
        if (ArithmeticOperation.PLUS.isEqusls(operator)) {
            return plus(operand1, operand2);
        }

        if (ArithmeticOperation.MINUS.isEqusls(operator)) {
            return minus(operand1, operand2);
        }

        if (ArithmeticOperation.MULTIPLICATION.isEqusls(operator)) {
            return multiplication(operand1, operand2);
        }

        if (ArithmeticOperation.DIVISION.isEqusls(operator)) {
            return division(operand1, operand2);
        }

        return 0;
    }

    public static double plus(double operand1, double operand2) {
        return operand1 + operand2;
    }

    public static double minus(double operand1, double operand2) {
        return operand1 - operand2;
    }

    public static double multiplication(double operand1, double operand2) {
        return operand1 * operand2;
    }

    public static double division(double operand1, double operand2) {
        return operand1 / operand2;
    }
}
