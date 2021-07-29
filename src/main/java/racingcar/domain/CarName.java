package racingcar.domain;

import racingcar.exception.InvalidCarNameException;

import java.util.Objects;

public class CarName {
    private final String name;
    private static final int BOUND = 5;

    public CarName(String name) {
        this.name = name.trim();
        if(name.length() > BOUND) {
            throw new InvalidCarNameException(name);
        }
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(name, carName1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
