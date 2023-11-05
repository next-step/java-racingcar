package racinggame.domain;

import racinggame.exception.ExceedNameSizeException;

import java.util.Objects;

public class Name {

    private static final int CAR_NAME_MAX_SIZE = 5;

    private String carName;

    public Name(String carName) {
        validateCarNameSize(carName);
        this.carName = carName;
    }

    public void validateCarNameSize(String carName) {
        if (carName.length() > CAR_NAME_MAX_SIZE) {
            throw new ExceedNameSizeException();
        }
    }

    @Override
    public String toString() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(carName, name.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

}
