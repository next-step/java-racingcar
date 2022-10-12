package racingcar.domain;


import java.util.Objects;

public class Name {
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateNullOrEmpty(name);
        validateOverMaximumLength(name);
        this.name = name;
    }

    private void validateOverMaximumLength(String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없다.");
        }
    }

    private void validateNullOrEmpty(String name) {
        if (Objects.isNull(name) || name.length() == 0) {
            throw new IllegalArgumentException("자동차 이름은 1글자 보다 작을 수 없다.");
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
        return Objects.hash(name);
    }
}
