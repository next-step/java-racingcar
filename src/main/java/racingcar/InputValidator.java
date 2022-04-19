package racingcar;

import static code.PromptMessage.CAR_NAME_IS_EQUAL_LOWER_THAN_5;

public class InputValidator {
    public static boolean isInputWrong(String input) {
        if (input.isBlank()) {
            System.out.println("입력 값은 빈 값이 안됩니다. 다시 입력 해주세요.");
            return true;
        }
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                System.out.println(CAR_NAME_IS_EQUAL_LOWER_THAN_5.getMessage());
                return true;
            }
        }
        return false;
    }
}
