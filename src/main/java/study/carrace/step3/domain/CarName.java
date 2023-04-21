package study.carrace.step3.domain;

import study.carrace.step3.domain.exception.IllegalCarNameException;

import java.util.Objects;

public class CarName {
    private static final int CAR_NAME_LENGTH_THRESHOLD = 5;
    private final String name;

    public CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if(name.length() > CAR_NAME_LENGTH_THRESHOLD) {
            throw new IllegalCarNameException(name);
        }
    }

    @Override
    public String toString() {
        return name;
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
}
