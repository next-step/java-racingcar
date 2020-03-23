package calculator;

import java.util.regex.Pattern;

public class Calculator {

    private static final String OPERAND_REGEX = "^[0-9]*$";
    private static final String OPERATOR_REGEX = "^[\\+\\-\\*\\/]{1}$";
    private static final Pattern OPERAND_PATTERN = Pattern.compile(OPERAND_REGEX);
    private static final Pattern OPERATOR_PATTERN = Pattern.compile(OPERATOR_REGEX);

    private String[] operandAndOperators;

    public Calculator(String[] operandAndOperators) {
        validateOperrandAndOperator(operandAndOperators);
        this.operandAndOperators = operandAndOperators;

    }

    /**
     * 피연산자가 숫자인지 검증
     */
    private void validateOperand(String operand) {
        if (!OPERAND_PATTERN.matcher(operand).find()) {
            throw new IllegalArgumentException("피연산자가 숫자가 아님");
        }
    }

    /**
     * 연산자가 사칙연산인지 체크 [+, -, *, /]
     */
    private void validateOperator(String operator) {
        if (!OPERATOR_PATTERN.matcher(operator).find()) {
            throw new IllegalArgumentException("연산자가 사칙연산이 아님");
        }
    }

    private void validateOperrandAndOperator(String[] operandAndOperators) {
        for (int i = 0; i < operandAndOperators.length; i++) {
            if (i % 2 == 0) {
                validateOperand(operandAndOperators[i]);
            } else {
                validateOperator(operandAndOperators[i]);
            }
        }
    }

    public double calculateUserInput() {
        double result = Double.parseDouble(operandAndOperators[0]);

        for (int i = 1; i < operandAndOperators.length; i += 2) {
            result = ArithmeticOperation.calculateInput(result, Double.parseDouble(operandAndOperators[i + 1]), operandAndOperators[i]);
        }

        return result;
    }
}
