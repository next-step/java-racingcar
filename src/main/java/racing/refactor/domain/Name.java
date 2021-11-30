package racing.refactor.domain;

import java.util.Objects;

public class Name {

    private static final int LIMITED_LENGTH = 5;

    private final String value;

    public Name(String value) {
        if(Objects.isNull(value)) {
            throw new IllegalArgumentException("이름은 null 일 수 없습니다.");
        }
        if(LIMITED_LENGTH < value.length()) {
            throw new IllegalArgumentException("제한 길이는 5자를 초과할 수 없습니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name=(Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Name{" +
                "value='" + value + '\'' +
                '}';
    }
}
