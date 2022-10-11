package racingcar;

import exception.CustomException;
import racingcar.exception.CarErrorCode;

import java.util.Objects;

public class Car {

    public static final int MOVE_DISTANCE = 1;
    public static final int NAME_MAXIMUM_VALUE = 5;

    private Integer location;
    private final String name;

    private Car(int location, String name) {
        validateName(name);
        this.location = location;
        this.name = name;
    }

    public static Car from(String name) {
        return new Car(0, name);
    }

    public static Car from(Car car) {
        return new Car(car.location, car.name);
    }

    public void moveForward() {
        location += MOVE_DISTANCE;
    }

    public Integer getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.length() > NAME_MAXIMUM_VALUE) {
            throw new CustomException(CarErrorCode.CAR_NAME_LENGTH_BAD_REQUEST);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(location, car.location) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, name);
    }
}
