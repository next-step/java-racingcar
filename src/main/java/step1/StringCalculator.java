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
        String[] splitedStringArray = splitStringBySpace(input);

        iterateClassification(splitedStringArray);
        iterateCalculation();
        return result;
    }

    private String[] splitStringBySpace(String input) {
        return input.split(SPACE_DELIMITER);
    }

    private void iterateClassification(String[] splitedStringArray) {
        for (String splitedString : splitedStringArray) {
            classificateOperandAndOperate(splitedString);
        }
    }

    private void classificateOperandAndOperate(String splitedString) {
        if (isNumeric(splitedString)) {
            operands.add(splitedString);
            return;
        }

        operates.add(splitedString);
    }

    private void iterateCalculation() {
        int size = operates.size();
        for (int i = 0; i < size; i++) {
            doCalculation(i, operates.get(i));
        }
    }

    private void doCalculation(int index, String operate) {
        int a, b;

        a = result;
        b = operands.get(index + 1);
        if (index == 0) {
            a = operands.get(index);
        }

        switch (operate) {
            case PLUS:
                add(a, b);
                break;
            case MINUS:
                subtract(a, b);
                break;
            case MULTIPLY:
                multiply(a, b);
                break;
            case DIVIDE:
                divide(a, b);
                break;
            default:
                break;
        }
    }

    public void add(int a, int b) {
        result = a + b;
    }

    public void subtract(int a, int b) {
        result = a - b;
    }

    public void multiply(int a, int b) {
        result = a * b;
    }

    public void divide(int a, int b) {
        try {
            result = a / b;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.", e);
        }
    }
}
