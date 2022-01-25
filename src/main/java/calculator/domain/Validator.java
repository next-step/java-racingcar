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
    
    public static void isRightOrder(List<String> parsedInput) {
        for (int i = 0; i < parsedInput.size(); i++) {
            String target = parsedInput.get(i);
            if (i % 2 == 0) {
                isNumber(target);
            } else {
                isOperator(target);
            }
        }
    }

    private static void isNumber(String target) {
        try {
            Double.parseDouble(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void isOperator(String target) {
        if (!("+".equals(target) || "-".equals(target) || "*".equals(target) || "/".equals(target))) {
            throw new IllegalArgumentException();
        }
    }
}
