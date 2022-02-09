package calculator;

import java.util.List;

public class Calculator {

    private static final String ZERO = "0";
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String ERROR_MESSAGE = "사칙 연산이 아닙니다";
    private static final String CANNOT_DIVIDE_BY_ZERO = "0으로 나뉠 수 없습니다";

    public int calculateByOperator(List<String> userInput) {
        int result = Integer.parseInt(userInput.get(0));
        int userInputSize = userInput.size();
        for (int i = 1; i < userInputSize - 1; i += 2) {
            int operand = Integer.parseInt(userInput.get(i + 1));
            if (PLUS.equals(userInput.get(i))) {
                result = sum(result, operand);
                continue;
            }
            if (MINUS.equals(userInput.get(i))) {
                result = subtract(result, operand);
                continue;
            }
            if (MULTIPLY.equals(userInput.get(i))) {
                result = multiply(result, operand);
                continue;
            }
            if (DIVIDE.equals(userInput.get(i))) {
                checkDivideByZero(userInput.get(i + 1));
                result = divide(result, operand);
                continue;
            }
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return result;
    }

    private void checkDivideByZero(String operand) {
        if (ZERO.equals(operand)) {
            throw new IllegalArgumentException(CANNOT_DIVIDE_BY_ZERO);
        }
    }

    private int sum(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b;
    }
}
