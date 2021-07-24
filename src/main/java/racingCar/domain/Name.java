package racingCar.domain;

import java.util.Objects;

public class Name {

    private final String name;
    private final static int MIN_LENGTH_BY_NAME = 1;
    private final static int MAX_VALUE_BY_NAME = 5;
    private final static String IS_NULL_OR_EMPTY_ERROR_MESSAGE = "자동차의 이름을 입력해주세요.";
    private final static String IS_NOT_BETWEEN_ONE_AND_FIVE_ERROR_MESSAGE = "자동차의 이름은 1~5글자 사이로 입력해야 합니다.";

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String name) {
        validateEmpty(name);
        validateNameLength(name);
    }

    private void validateEmpty(String name) {
        if(isNameEmpty(name)) {
            throw new IllegalArgumentException(IS_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    private boolean isNameEmpty(String name) {
        return Objects.isNull(name) || name.trim().isEmpty();
    }

    private void validateNameLength(String name) {
        if(isNameOverSize(name.trim())) {
            throw new IllegalArgumentException(IS_NOT_BETWEEN_ONE_AND_FIVE_ERROR_MESSAGE);
        }
    }

    private boolean isNameOverSize(String name) {
        return name.length() < MIN_LENGTH_BY_NAME || name.length() > MAX_VALUE_BY_NAME;
    }

    public String getName() {
        return this.name;
    }

}
