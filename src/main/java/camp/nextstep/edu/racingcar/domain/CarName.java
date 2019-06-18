package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.StringUtils;

import java.util.Objects;

public class CarName {
    private final String value;

    private CarName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("'name' must not be null or empty");
        }
        this.value = name;
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return value.equals(carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
