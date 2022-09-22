package racingcar;

import java.util.Objects;

public class Car {
    private static final Integer MOVE_CRITERIA = 4;

    private final Integer currentPosition;
    private final String name;

    public Car(Integer currentPosition, String name) {
        this.currentPosition = currentPosition;
        this.name = name;
    }

    public static Car of(Integer position, String name) {
        return new Car(position, name);
    }

    public Integer currentPosition() {
        return currentPosition;
    }

    public String name() {
        return name;
    }

    public Integer nextPosition(Integer randomNumber) {
        if (randomNumber >= MOVE_CRITERIA) {
            return currentPosition + 1;
        }
        return currentPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(currentPosition, car.currentPosition) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentPosition, name);
    }
}
