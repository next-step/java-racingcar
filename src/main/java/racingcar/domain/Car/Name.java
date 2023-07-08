package racingcar.domain.Car;

import java.util.Objects;

public class Name {
    private final int MAX_NAME_LENGTH = 5;
    private final int MIN_NAME_LENGTH = 1;
    private final String name;

    public Name(String value) {
        validate(value);
        this.name = value;
    }

    private void validate(String value) {
        if (value.length() > MAX_NAME_LENGTH || value.length() < MIN_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름이 유효하지 않습니다");
        }
    }

    public String get() {
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
