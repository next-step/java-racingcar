package calculator;

import java.util.regex.Pattern;

public class Calculator {

    private static final String OPERAND_REGEX = "^[0-9]*$";
    private static final String OPERATOR_REGEX = "^[\\+\\-\\*\\/]{1}$";
    private static final Pattern OPERAND_PATTERN = Pattern.compile(OPERAND_REGEX);
    private static final Pattern OPERATOR_PATTERN = Pattern.compile(OPERATOR_REGEX);

    private String[] operandAndOperators;

    public Calculator(String[] operandAndOperators) {
        this.operandAndOperators = operandAndOperators;
    }

    /**
     * 피연산자가 숫자인지 검증
     */
    public static void validateOperand(String operand) {
        if (!OPERAND_PATTERN.matcher(operand).find()) {
            throw new IllegalArgumentException("피연산자가 숫자가 아님");
        }
    }

    /**
     * 연산자가 사칙연산인지 체크 [+, -, *, /]
     */
    public static void validateOperator(String operator) {
        if (!OPERATOR_PATTERN.matcher(operator).find()) {
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
