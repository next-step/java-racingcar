package racingcar.domain;

import racingcar.dto.CarDto;

import java.util.Objects;

public class Car {
    private final CarName name;
    private CarPosition position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public CarDto toDto() {
        return new CarDto(name.getValue(), position.getValue());
    }

    public boolean move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position.move();
            return true;
        }
        return false;
    }

    public boolean isSamePositionWith(Car other) {
        return position.equals(other.position);
    }

    public boolean isAheadOf(Car other) {
        return position.isAheadOf(other.position);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}