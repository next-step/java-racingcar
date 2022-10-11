package racingcar;

import exception.CustomException;
import racingcar.exception.CarErrorCode;

import java.util.Objects;

public class CarName {


    public static final int NAME_MAXIMUM_VALUE = 5;

    private final String name;

    private CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    private void validateName(String name) {
        if (name.length() > NAME_MAXIMUM_VALUE) {
            throw new CustomException(CarErrorCode.CAR_NAME_LENGTH_BAD_REQUEST);
        }
    }

    public String getName() {
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
