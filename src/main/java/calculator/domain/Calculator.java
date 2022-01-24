package calculator.domain;

import calculator.Constant;
import java.util.List;

public class Calculator {

    private int result;
    private final List<String> splitedInput;

    public Calculator(List<String> splitExpression) {
        result = Integer.parseInt(splitExpression.get(0));

        validateExpression(splitExpression);
        calculateNumbers(splitExpression);
    }

    public int getResult() {
        calculateNumbers();

        return result;
    }

    private void calculateNumbers() {
        for (int i = Constant.INIT_ARITHMETIC; i < splitedInput.size();
            i += Constant.NEXT_ARITHMETIC) {
            char arithmetic = splitedInput.get(i).charAt(0);
            int number = Integer.parseInt(splitedInput.get(i + 1));

        for (int i = Constant.INIT_OPERATOR_INDEX; i < splitExpression.size();
            i += Constant.NEXT_OPERATOR_DIFFERENCE) {
            char operator = splitExpression.get(i).charAt(0);
            int number = Integer.parseInt(splitExpression.get(i + 1));

            switch (operator) {
                case Constant.ADD:
                    addNumbers(number);
                    break;
                case Constant.SUB:
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
}
