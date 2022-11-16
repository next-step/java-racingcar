package laststep.domain;

import java.util.Objects;
import laststep.service.MoveStrategy;

public class Car implements Comparable<Car> {
    private final Name name;
    private Position position;

    public Car(String participant) {
        name = new Name(participant);
        position = new Position();
    }

    public void move(MoveStrategy strategy) {
        if (strategy.isMovable()) {
            position = position.increase();
        }
    }

    public boolean isWinner(Car other) {
        return position.isPosition(other.position);
    }

    public String printName() {
        return this.name.print();
    }

    public String printPosition() {
        return this.position.print();
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
    public int compareTo(Car other) {
        return this.position.compare(other.position);
    }
}
