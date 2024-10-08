package study.validation;

import study.racing.constants.RacingMessage;

public class InputValidation {

    public static boolean racingInputValidation(String carCount, String tryCount) {
        if(carCount.isBlank() && tryCount.isBlank()) {
            return false;
        }

        return validateCounts(carCount, tryCount);
    }

    public static boolean validateCounts(String carCount, String tryCount) {
        boolean isCarCountValid = carCountValidation(carCount);
        boolean isTryCountValid = tryCountValidation(tryCount);

        return isCarCountValid && isTryCountValid;
    }

    public static boolean carCountValidation(String carCount) {

        try {
            if(Integer.parseInt(carCount) < 0 ) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println(RacingMessage.TRY_AGAIN.msg());
            return false;
        }

        return true;
    }

    public static boolean tryCountValidation(String tryCount) {

        try {
            if(Integer.parseInt(tryCount) < 0 ) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println(RacingMessage.TRY_AGAIN.msg());
            return false;
        }

        return true;
    }

    public static boolean racingInputValidationForNames(String carName, String tryCount) {

        if(carName.isBlank() && tryCount.isBlank()) {
            return false;
        }

        boolean isTryCountValid = tryCountValidation(tryCount);
        boolean isCarNameValid = carNameValidation(carName);

        return isTryCountValid && isCarNameValid;
    }

    public static boolean carNameValidation(String carName) {
        String[] splitNames = carName.trim().split(",");
        int emptyCount = 0;

        for(String name : splitNames) {
            emptyCount += nameEmptyValidation(name);
        }

        if(emptyCount > 1) {
            return false;
        }

        return true;
    }

    public static int nameEmptyValidation(String word) {
        return word.isBlank() ? 1 : 0;
    }
}
