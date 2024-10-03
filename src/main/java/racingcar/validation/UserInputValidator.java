package racingcar.validation;

import racingcar.exception.GameException;

public class UserInputValidator {

    public static void numberInputValidate(String numberInput) {
        nullOrEmptyCheck(numberInput);
        numberFormatCheck(numberInput);
        positiveNumberCheck(numberInput);
    }

    private static void nullOrEmptyCheck(String carCount) {
        if (carCount == null || carCount.isBlank()) {
            throw new GameException("올바른 입력값이 아닙니다.");
        }
    }

    private static void numberFormatCheck(String numberInput) {
        try {
            Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            throw new GameException("숫자만 가능합니다.");
        }
    }

    private static void positiveNumberCheck(String numberInput) {
        if (Integer.parseInt(numberInput) < 0) {
            throw new GameException("양수를 입력해주세요.");
        }
    }


}
