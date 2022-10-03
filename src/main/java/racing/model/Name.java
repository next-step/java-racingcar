package racing.model;

import java.util.Objects;

public class Name {
    private static final String NULL_OR_BLANK_ERROR_MESSAGE = "자동차의 이름은 빈 문자열 혹은 Null로 설정할 수 없습니다.";
    private static final String FIVE_LENGTH_OVER_ERROR_MESSAGE = "자동차의 이름은 5자를 초과할 수 없습니다. 입력한 자동차이름 : ";
    private static final int MAX_LENGTH = 5;
    private final String name;


    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_BLANK_ERROR_MESSAGE);
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(FIVE_LENGTH_OVER_ERROR_MESSAGE + name);
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return getName().equals(name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
