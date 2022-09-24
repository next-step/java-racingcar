package racing.domain.car;

import java.util.Objects;

public class Car {

    private final Position position;
    private final Name name;

    public Car(Position position, Name name) {
        this.position = position;
        this.name = name;
    }

    public Car(String name) {
        this(new Position(0), new Name(name));
    }

    public Car(int position, String name) {
        this(new Position(position), new Name(name));
    }

    public Car move() {
        return new Car(position.advance(), this.name);
    }

    public int position() {
        return position.value();
    }

    public Name name() {
        return name;
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
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
