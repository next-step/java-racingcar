package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final String MAX_CAR_NAME_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String INVALID_NAME_MESSAGE = "적어도 이름은 1자 이상이여야 합니다.";
    public static final int NAME_MAXIMUM_LENGTH = 5;

    private final String value;


    public Name(String value) {
        validationName(value);
        this.value = value.trim();
    }

    private void validationName(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        if (value.trim().length() > NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(MAX_CAR_NAME_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}