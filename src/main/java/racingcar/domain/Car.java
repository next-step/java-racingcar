package racingcar.domain;

import java.util.Objects;

public class Car {

    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.position = position;
        this.name = name;
    }

    public static Car create(String name) {
         return new Car(new Name(name), Position.init());
    }

    public void move(int number) {
        this.position.move(number);
    }

    public Name name() {
        return this.name;
    }

    public int positionNumber() {
        return this.position.position();
    }

    public Position position() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
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
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
