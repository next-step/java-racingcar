package racing.domain;

import java.util.List;
import java.util.Objects;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String title) {
        this(new Name(title), new Position());
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car move(MovingStrategy strategy) {
        if (strategy.moveable()) {
            return new Car(this.name, this.position.increasePosition());
        }
        return this;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Position getBetterPosition(Position maxPosition) {
        return this.position.betterThan(maxPosition);
    }

    public List<Car> addWinner(Position maxPosition, List<Car> winners) {
        if (this.position.equals(maxPosition)) {
            winners.add(this);
        }
        return winners;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Car)) {
            return false;
        }

        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(position);
        return result;
    }
}
