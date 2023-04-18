package step5.domain;

import java.util.Objects;

public class Name {

    private final String name;
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String MESSAGE_FOR_BLANK_NAME = "자동차 이름은 빈칸일 수 없습니다.";
    private static final String MESSAGE_FOR_NAME_LENGTH_LIMIT = "자동차 이름은 5자를 초과할 수 없습니다.";

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(MESSAGE_FOR_BLANK_NAME);
        }
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(MESSAGE_FOR_NAME_LENGTH_LIMIT);
        }
    }

    public String getName() {
        return this.name;
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

    @Override
    public String toString() {
        return name;
    }

}
