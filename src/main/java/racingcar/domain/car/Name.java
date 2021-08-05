package racingcar.domain.car;

import racingcar.exception.InvalidCarSettingException;

public class Name {
    private String name;
    private static final String INVALID_BLANK_CAR_NAME_MESSAGE = "자동차 이름은 공백이 불가합니다.";
    private static final String INVALID_LENGTH_CAR_NAME_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";

    public Name(String name) {
        checkNameValidation(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void checkNameValidation(String name) {
        checkBlankCarName(name);
        checkLengthCarName(name);
    }

    private void checkBlankCarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidCarSettingException(INVALID_BLANK_CAR_NAME_MESSAGE);
        }
    }

    private void checkLengthCarName(String name) {
        if (name.length() > 5) {
            throw new InvalidCarSettingException(INVALID_LENGTH_CAR_NAME_MESSAGE);
        }
    }
}
