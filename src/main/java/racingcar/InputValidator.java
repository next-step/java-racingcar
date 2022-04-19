package racingcar;

import static code.PromptMessage.CAR_NAME_IS_EQUAL_LOWER_THAN_5;
import static code.PromptMessage.INPUT_HAVE_TO_BE_NOT_BLANK;

public class InputValidator {
    public static boolean isInputWrong(String input) {
        if (input.isBlank()) {
            System.out.println(INPUT_HAVE_TO_BE_NOT_BLANK);
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
