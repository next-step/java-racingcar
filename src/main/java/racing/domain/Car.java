package racing.domain;

import java.util.Objects;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this(new Name(name), new Position());
    }

    public Car(Name name) {
        this(name, new Position());
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car goForward(boolean trigger) {
        if (trigger) {
            return new Car(this.name, this.position.next());
        }
        return new Car(this.name, this.position);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.getName();
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
}
