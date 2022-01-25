package racinggame.domain;

import static racinggame.domain.Constants.*;

public class Validator {

    public static void validatePossibleToStart(String[] carNames) {
        if (carNames.length < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("참가자는 2명 이상입니다.");
        }
    }

    public static void validateNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름의 글자 수는 5자 이하입니다.");
        }
    }

    public static void isNumber(String trial) {
        try {
            Integer.parseInt(trial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 숫자로 입력해주세요.");
        }
    }
}
