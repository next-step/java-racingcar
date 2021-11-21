package racing.model;

import java.util.Objects;

/**
 * .
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
        this.position = new Position(car.position.getPosition());
    }

    public String stringName() {
        return name.getName();
    }

    public int intPosition() {
        return position.getPosition();
    }

    public void move(int condition) {
        position = position.moveOnSatisfiedCondition(condition);
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
