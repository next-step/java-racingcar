package racinggame.domain;

public class Validator {

    public static final int MINIMUM_PLAYER = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private Validator() {}

    public static void validatePossibleToStart(String[] carNames) {
        if (carNames.length < MINIMUM_PLAYER) {
            throw new IllegalArgumentException(String.format("참가자는 %d명 이상입니다.", MINIMUM_PLAYER));
        }
    }

    public static void validateNameLength(String carName) {
        if (carName.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름의 글자 수는 %d자 이하입니다.", MAXIMUM_NAME_LENGTH));
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
