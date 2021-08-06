package step5;

import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if (isNullOrEmpty(name)) {
            throw new IllegalArgumentException("자동차의 이름이 비었습니다.");
        }
        if (isNameSizeOutOfRange(name)){
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    private boolean isNullOrEmpty(String name) {
        return name == null || name.isEmpty();
    }

    private boolean isNameSizeOutOfRange(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    @Override
    public String toString() {
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
        return Objects.hash(name);
    }
}
