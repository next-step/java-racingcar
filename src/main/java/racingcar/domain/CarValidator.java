package racingcar.domain;

public class CarValidator {
    private static final int NAME_MAX_LENGTH = 5;
    private static String NAME_LENGTH_MAX_CONSTRAINT_ERROR_MESSAGE = String.format("자동차 이름은 %d자를 초과할 수 없습니다.", NAME_MAX_LENGTH);

    private CarValidator() {
    }

    static void verifyNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_MAX_CONSTRAINT_ERROR_MESSAGE);
        }
    }
}
