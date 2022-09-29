package racingcar.step3_4;

import java.util.Objects;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateBlank(name);
        validateOverFiveCharacters(name);
        this.name = name;
    }

    private void validateBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("1자 이상의 이름을 입력해주세요.");
        }
    }

    private void validateOverFiveCharacters(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
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
