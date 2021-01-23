package calculator;

import java.util.ArrayDeque;

public class Validator {
    public static void checkEmptyInput(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("공백이거나 비었습니다. 다시 입력해 주세요.");
        }
    }

    public static void checkExpression(ArrayDeque<String> expression) throws IllegalArgumentException {
        checkSizeOfExpression(expression);
        checkNumberAndOperator(expression);
    }

    private static void checkSizeOfExpression(ArrayDeque<String> expression) throws IllegalArgumentException {
        if (expression.size() % 2 == 0) {
            throw new IllegalArgumentException("식의 항의 수가 맞지 않아 식이 성립하지 않습니다. 다시 입력해 주세요.");
        }
    }

    private static void checkNumberAndOperator(ArrayDeque<String> expression) throws IllegalArgumentException {
        boolean isNumber = true;
        for (String term : expression) {
            if (isNumber) {
                checkNumber(term);
            } else {
                checkOperator(term);
            }
            isNumber = !isNumber;
        }
    }

    private static void checkNumber(String stringNumber) throws IllegalArgumentException {
        try {
            Double.parseDouble(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 데이터 위치에 숫자 데이터가 아닙니다.");
        }
    }

    private static void checkOperator(String operator) throws IllegalArgumentException {
        switch (operator) {
            case "+":
            case "-":
            case "/":
            case "*":
                break;
            default:
                throw new IllegalArgumentException("알맞은 연산자를 입력해주세요.");
        }
    }
}