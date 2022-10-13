package nextstep.javaracingcar;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(final String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 빈값 일 수 없습니다.");
        }

        final String trimmedName = name.trim();
        if (trimmedName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }

        this.name = trimmedName;
    }

    public String value() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final CarName carName = (CarName) o;

        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }
}
