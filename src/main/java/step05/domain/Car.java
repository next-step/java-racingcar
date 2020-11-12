package step05.domain;

import step03.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private final CarName name;
    private final CarPosition position;

    private Car(CarName carName, CarPosition carPosition) {
        this.name = carName;
        this.position = carPosition;
    }

    public static Car of(String name) {
        return new Car(CarName.of(name), CarPosition.of());
    }

    public static Car of(String name, int position) {
        return new Car(CarName.of(name), CarPosition.of(position));
    }

    public static Car of(String name, int position, int maxLength) {
        return new Car(CarName.of(name, maxLength), CarPosition.of(position));
    }

    public Car move(MoveStrategy moveStrategy) {
        return new Car(name, position.move(moveStrategy));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
