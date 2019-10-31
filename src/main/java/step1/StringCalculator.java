package step1;

import static step1.Utils.ValidationUtils.*;

public class StringCalculator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String SPACE_DELIMITER = " ";

    private int result;
    OperateCollection operates;
    OperandCollection operands;

    StringCalculator() {
        result = 0;
        operates = new OperateCollection();
        operands = new OperandCollection();
    }

    public int calculate(String input) {
        isBlankThrowException(input);
        String[] splitedExpressions = splitStringBySpace(input);

        iterateClassification(splitedExpressions);
        iterateCalculation();
        return result;
    }

    private String[] splitStringBySpace(String input) {
        return input.split(SPACE_DELIMITER);
    }

    private void iterateClassification(String[] splitedExpressions) {
        for (String splitedExpression : splitedExpressions) {
            classificateOperandAndOperate(splitedExpression);
        }
    }

    private void classificateOperandAndOperate(String splitedExpression) {
        if (isNumeric(splitedExpression)) {
            operands.add(splitedExpression);
            return;
        }

        operates.add(splitedExpression);
    }

    private void iterateCalculation() {
        int size = operates.size();
        for (int i = 0; i < size; i++) {
            doCalculation(i, operates.get(i));
        }
    }

    private void doCalculation(int index, String operate) {
        int firstOperand;
        int secondOperand;
        int nextOperandIndex = index + 1;

        firstOperand = result;
        secondOperand = operands.get(nextOperandIndex);

        if (index == 0) {
            firstOperand = operands.get(index);
        }

        switch (operate) {
            case PLUS:
                add(firstOperand, secondOperand);
                break;
            case MINUS:
                subtract(firstOperand, secondOperand);
                break;
            case MULTIPLY:
                multiply(firstOperand, secondOperand);
                break;
            case DIVIDE:
                divide(firstOperand, secondOperand);
                break;
            default:
                break;
        }
    }

    public int add(int a, int b) {
        return result = a + b;
    }

    public int subtract(int a, int b) {
        return result = a - b;
    }

    public int multiply(int a, int b) {
        return result = a * b;
    }

    public int divide(int a, int b) {
        try {
            return result = a / b;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.", e);
        }
    }
}
