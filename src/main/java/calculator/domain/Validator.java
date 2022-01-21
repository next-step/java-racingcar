package calculator.domain;

public class Validator {

    public static void isEmpty(String userInput) {
        if (userInput == null || userInput.trim().length() == 0) {
            throw new IllegalArgumentException("[ERROR] 연산 가능한 수식을 입력해주세요.");
        }
    }
}
