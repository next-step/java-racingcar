package step5.dto;

import step5.common.MyException;

import java.util.Objects;

public class CarName {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validNameOrThrow(name);

        this.name = name;
    }

    public CarName(CarName name) {
        this.name = name.name;
    }

    public String getName() {
        return name;
    }

    private void validNameOrThrow(String name) {
        int nameLength = name.length();
        if(MIN_LENGTH > nameLength || nameLength > MAX_LENGTH) {
            throw new IllegalArgumentException(MyException.INVALID_NAME_LENGTH.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
