package racinggame.domain.racingcar;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_INVALID_NAME = "자동차 이름은 5자 이하여야 합니다.";

    private final String value;

    public CarName(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_NAME + ": " + name);
        }
    }

    public String getValue() {
        return value;
    }
}
