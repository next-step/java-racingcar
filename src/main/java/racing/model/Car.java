package racing.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
 *
 * Car
 *
 * @version 1.0.0
 *
 * 2021-11-23
 *
 * Copyright tnals1422
 */
public class Car {

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(Car car) {
        this.name = new Name(car.name.getName());
        this.position = new Position(car.position.getValue());
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(int condition) {
        position = position.moveOnSatisfiedCondition(condition);
    }

    public boolean isWinner(List<Car> cars) {
        List<Position> positions
                = cars.stream()
                .map(car -> car.position)
                .collect(Collectors.toList());

        return this.position.isTopPosition(positions);
    }

    public String stringName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
