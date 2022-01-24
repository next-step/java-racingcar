package calculator.domain;

import java.util.regex.Pattern;

public class Validator {

    public Validator(String userInput) {
        isEmpty(userInput);
        canCalculate(userInput);
    }

    public static void isEmpty(String userInput) {
        if (userInput == null || userInput.trim().length() == 0) {
            throw new IllegalArgumentException("[ERROR] 연산 가능한 수식을 입력해주세요.");
        }
    }

    public static void canCalculate(String userInput) {
        String cannotCalculate = "(.*)[^\\s\\d+*/-](.*)";
        if (userInput.matches(cannotCalculate)) {
            throw new IllegalArgumentException("[ERROR] 숫자, 연산자, 공백 문자만 허용됩니다.");
        }
    }
}
