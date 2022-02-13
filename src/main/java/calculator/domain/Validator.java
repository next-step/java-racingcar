package calculator.domain;

import java.util.List;

public class Validator {
    private static final String NOT_A_NUMBER_NOR_OPERATOR_REGX = "(.*)[^\\s\\d+*/-](.*)";

    public static void checkInput(String userInput) {
        checkEmpty(userInput);
        checkInputType(userInput);
    }

    public static void checkEmpty(String userInput) {
        if (userInput == null || userInput.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkInputType(String userInput) {
        if (userInput.matches(NOT_A_NUMBER_NOR_OPERATOR_REGX)) {
            throw new IllegalArgumentException();
        }
    }
    
    public static void checkOrder(List<String> parsedInputs) {
        int inputSize = parsedInputs.size();
        for (int i = 0; i < inputSize; i++) {
            String target = parsedInputs.get(i);
            checkType(target, i);
        }
    }

    private static void checkType(String target, int index) {
        if (isEven(index)) {
            shouldNumber(target);
        } else {
            shouldOperator(target);
        }
    }

    private static boolean isEven(int index) {
        return index % 2 == 0;
    }

    private static void shouldNumber(String target) {
        try {
            Double.parseDouble(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 연산 가능한 수식을 입력해주세요.");
        }
    }

    private static void shouldOperator(String target) {
        if (!Operator.isOperator(target)) {
            throw new IllegalArgumentException("[ERROR] 연산 가능한 수식을 입력해주세요.");
        }
    }
}
