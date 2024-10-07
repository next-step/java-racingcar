package study.validation;

import study.racing.constants.RacingMessage;

public class InputValidation {

    public static boolean racingInputValidation(String carCount, String tryCount) {

        boolean isInputMatchType = true;

        if(carCount.isBlank() && tryCount.isBlank()) {
            return isInputMatchType = false;
        }

        try {
            if(Integer.parseInt(carCount) < 0 || Integer.parseInt(tryCount) < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            isInputMatchType = false;
            System.out.println(RacingMessage.TRY_AGAIN.msg());
        }

        return isInputMatchType;
    }
}
