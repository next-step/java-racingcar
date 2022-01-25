package racinggame.domain;

public class Validator {

    private static final int MINIMUM_PLAYER = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private Validator() {}

    public static void validatePossibleToStart(String[] carNames) {
        if (carNames.length < MINIMUM_PLAYER) {
            throw new IllegalArgumentException("참가자는 2명 이상입니다.");
        }
    }

    public static void validateNameLength(String carName) {
        if (carName.length() > MAXIMUM_NAME_LENGTH) {
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
