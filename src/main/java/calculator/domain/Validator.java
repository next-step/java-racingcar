package calculator.domain;

import java.util.InputMismatchException;

public class Validator {
    protected static final String OPERATORS = "+-*/";

    private Validator() {}

    public static void checkIsBlack(String userInput) {
        if (isBlank(userInput)) {
            throw new IllegalArgumentException("[ERROR] 식을 입력해 주세요.");
        }
    }

    private static boolean isBlank(String userInput) {
        return userInput.replaceAll("\\s+", "").equals("");
    }


    public static void validateIsNumber(String target) {
        try{
            Double.parseDouble(target);
        } catch (NumberFormatException e){
            throw new InputMismatchException("[ERROR] 해당 자리에는 숫자가 위치해야 합니다.(v op v op v ..)");
        }
    }

    public static void validateIsOperator(String target) {
        if (!OPERATORS.contains(target)) {
            throw new InputMismatchException("[ERROR] 해당 자리에는 연산자가 위치해야 합니다.(v op v op v ..)");
        }
    }
}
