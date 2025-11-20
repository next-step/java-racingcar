package racingCar.domain;

import java.util.Objects;

public class Name {
    private static final int LIMIT_NAME_LENGH = 5;
    private final String value;
    public Name(String name) {
        checkName(name);
        this.value = name;
    }

    public String value() {
        return this.value;
    }
    private void checkName(String name) {
        if (name.length() > LIMIT_NAME_LENGH) {
            throw new RuntimeException("이름이 5글자 초과되면 안됩니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Name{" +
                "value='" + value + '\'' +
                '}';
    }
}
