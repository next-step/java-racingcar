package study.racing.domain;

import java.util.Objects;

public class Car {
    private final CarName name;
    private CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public void move(Torque torque) {
        if (torque.isMovable()) {
            this.position = position.increase();
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    public boolean isPositionGreaterThan(Car other) {
        return this.position.isGreaterThan(other.position);
    }

    public boolean isSamePosition(Car other) {
        return this.position.equals(other.position);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{name= " + name.getValue() + ", position= " + position.getValue() + "}";
    }
}
