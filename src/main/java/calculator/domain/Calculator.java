package calculator.domain;

import calculator.Constant;
import java.util.List;

public class Calculator {

    public int result;

    public Calculator(List<String> splitExpression) {
        result = Integer.parseInt(splitExpression.get(0));

        validateExpression(splitExpression);
        calculateNumbers(splitExpression);
    }

    public void printResult() {
        System.out.println(result);
    }

    public int getResult() {
        return result;
    }

    private void calculateNumbers(List<String> splitExpression) {

        for (int i = Constant.INIT_OPERATOR_INDEX; i < splitExpression.size();
            i += Constant.NEXT_OPERATOR_DIFFERENCE) {
            char operator = splitExpression.get(i).charAt(0);
            int number = Integer.parseInt(splitExpression.get(i + 1));

            switch (operator) {
                case Constant.ADD:
                    addNumbers(number);
                    break;
                case Constant.SUBTRACT:
                    subtractNumbers(number);
                    break;
                case Constant.MULTIPLY:
                    multiplyNumbers(number);
                    break;
                case Constant.DIVIDE:
                    divideNumbers(number);
            }
        }
    }

    private void addNumbers(int number) {
        result += number;
    }

    private void subtractNumbers(int number) {
        result -= number;
    }

    private void multiplyNumbers(int number) {
        result *= number;
    }

    private void divideNumbers(int number) {
        result /= number;
    }

    private void validateExpression(List<String> splitExpression) {
        boolean isValidExpressionSize = splitExpression.size() % 2 == 0;
        if (isValidExpressionSize) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 식입니다.");
        }
    }
}
