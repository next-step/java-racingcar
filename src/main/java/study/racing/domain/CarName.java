package study.racing.domain;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자를 초과할 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "CarName{value=" + value + " }";
    }
}
