package racingcar.domain;

public class Name {

    private static final String MAX_CAR_NAME_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String INVALID_NAME_MESSAGE = "적어도 이름은 1자 이상이여야 합니다.";

    private final String value;

    public Name(String value) {
        validationName(value);
        this.value = value;
    }

    private void validationName(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException(MAX_CAR_NAME_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }
}