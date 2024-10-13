package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final String MAX_CAR_NAME_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String INVALID_NAME_MESSAGE = "적어도 이름은 1자 이상이여야 합니다.";

    private final String name;


    public Name(String name) {
        validationName(name.trim());
        this.name = name;
    }

    private void validationName(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException(MAX_CAR_NAME_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}