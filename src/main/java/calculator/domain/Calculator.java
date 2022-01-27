package calculator.domain;

import calculator.Operator;
import java.util.List;

public class Calculator {

    public static final int INIT_OPERATOR_INDEX = 1;
    public static final int NEXT_OPERATOR_DIFFERENCE = 2;
    public int result;

    public Calculator(List<String> splitExpression) {
        if ( splitExpression.size() % 2 == 0) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 식입니다.");
        }
        validateEmptyExpression(splitExpression);
        result = Integer.parseInt(splitExpression.get(0));

        validateOperandAndOperator(splitExpression);

        calculateNumbers(splitExpression);
    }

    public void printResult() {
        System.out.println(result);
    }

    public int getResult() {
        return result;
    }

    private void calculateNumbers(List<String> splitExpression) {

        for (int i = INIT_OPERATOR_INDEX; i < splitExpression.size();
            i += NEXT_OPERATOR_DIFFERENCE) {
            String symbol = splitExpression.get(i);
            int number = Integer.parseInt(splitExpression.get(i + 1));

            Operator operator = Operator.findBySymbol(symbol);
            result = operator.operate(result, number);
        }
    }

    private boolean isOperandPosition(int i) {
        return i % 2 == 0;
    }

    private boolean isOperatorPosition(int i) {
        return i % 2 == 1;
    }

    private void validateOperandAndOperator(List<String> splitExpression) {
        for (int i = 0; i < splitExpression.size(); i++) {
            if (isOperandPosition(i)) {
                validateOperand(splitExpression.get(i));
            }

            if (isOperatorPosition(i)) {
                validateOperator(splitExpression.get(i));
            }
        }
    }

    private void validateOperand(String operand) {
        boolean isOperator = operand.matches("[+\\-*/]");

        if (isOperator) {
            throw new IllegalArgumentException("[ERROR] 연속된 문자는 입력 불가합니다.");
        }
    }

    private void validateOperator(String operator) {
        boolean isOperand = operator.matches("[0-9]");

        if (isOperand) {
            throw new IllegalArgumentException("[ERROR] 연속된 숫자는 입력 불가합니다.");
        }
    }

    private void validateEmptyExpression(List<String> splitExpression) {
        if (splitExpression.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열 입니다.");
        }
    }
}
