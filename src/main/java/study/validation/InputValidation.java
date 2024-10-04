package study.validation;

import study.racing.RacingMessage;

public class InputValidation {

    public static boolean racingInputValidation(String inputCount) {

        boolean isInputMatchType = true;

        if(inputCount.isBlank()) {
            return isInputMatchType;
        }

        try {
            if(Integer.parseInt(inputCount) < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println(RacingMessage.TRY_AGAIN.msg());
            isInputMatchType = false;
        }

        return isInputMatchType;
    }
}
