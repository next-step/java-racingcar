package racing.domain;

import racing.domain.vo.Name;
import racing.domain.vo.Position;

import java.util.Objects;

public class Car {

    private Name name;
    private Position position;

    public Car(Name name) {
        this(name, new Position());
    }

    public Car(Name name,
               Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(int chance) {
        this.position.movePosition(chance);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getNumber();
    }

    public Position getBiggerPosition(Position other) {
        return this.position.biggerPosition(other);
    }

    public boolean isSamePosition(Position position) {
        return this.position.equals(position);
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
