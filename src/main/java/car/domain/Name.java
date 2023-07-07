package car.domain;

import java.util.Objects;

public class Name {

    private final String value;
    private static final int MAX_NAME_LENGTH = 5;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private static void validate(final String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 5자 이하여야 합니다. 입력한 데이터 : %s", value));
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
