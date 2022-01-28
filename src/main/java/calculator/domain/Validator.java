package calculator.domain;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private static final String NOT_A_NUMBER_NOR_OPERATOR = "(.*)[^\\s\\d+*/-](.*)";

    public Validator(String userInput) {
        isEmpty(userInput);
        canCalculate(userInput);
    }

    public static void isEmpty(String userInput) {
        if (userInput == null || userInput.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void canCalculate(String userInput) {
        if (userInput.matches(NOT_A_NUMBER_NOR_OPERATOR)) {
            throw new IllegalArgumentException();
        }
    }
    
    public static void isRightOrder(List<String> parsedInputs) {
        int inputSize = parsedInputs.size();
        for (int i = 0; i < inputSize; i++) {
            String target = parsedInputs.get(i);
            isCorrectType(target, i);
        }
    }

    private static void isCorrectType(String target, int index) {
        if (isEven(index)) {
            isNumber(target);
        } else {
            isOperator(target);
        }
    }

    private static boolean isEven(int index) {
        return index % 2 == 0;
    }

    private static void isNumber(String target) {
        try {
            Double.parseDouble(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 연산 가능한 수식을 입력해주세요.");
        }
    }

    private static void isOperator(String target) {
        if (!Operator.isOperator(target)) {
            throw new IllegalArgumentException("[ERROR] 연산 가능한 수식을 입력해주세요.");
        }
    }
}
