package racing.domain;

import java.util.Objects;

public class Name {

    private static final String MAXIMUM_NAME_ERROR_TEXT = "이름은 5자를 초과할 수 없습니다.";
    private static final String MINIMUM_NAME_ERROR_TEXT = "1자 이상의 이름을 입력해주세요.";
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        this.name = validateName(name);
    }

    public String getName() {
        return name;
    }

    private String validateName(String name) {
        validateBlank(name);
        validateOverFiveCharacters(name);

        return name;
    }

    private void validateBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(MINIMUM_NAME_ERROR_TEXT);
        }
    }

    private void validateOverFiveCharacters(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(MAXIMUM_NAME_ERROR_TEXT);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
