package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String value;

    public Name(String value) {
        verify(value);
        this.value = value;
    }

    private void verify(String value) {
        if (isNullOrEmpty(value)) {
            throw new IllegalArgumentException("이름은 null 또는 공백일 수 없습니다.");
        }

        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최소 1글자 이상 5글자 이하여야만 합니다.");
        }
    }

    private boolean isNullOrEmpty(String value) {
        return Objects.isNull(value) || value.isEmpty();
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
