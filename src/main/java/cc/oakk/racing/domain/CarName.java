package cc.oakk.racing.domain;

import cc.oakk.racing.util.StringUtils;

import java.util.Objects;

public class CarName {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("Given name is empty!");
        }

        if (StringUtils.isLengthGreaterThanOrEqual(name, MAX_LENGTH)) {
            throw new IllegalArgumentException(String.format("name's length shouldn't be greater than %d.", MAX_LENGTH));
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
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
