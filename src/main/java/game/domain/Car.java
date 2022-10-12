package game.domain;

import game.domain.movable.MovableStrategy;

import java.util.Objects;

import static game.domain.Position.DEFAULT_POSITION;


public class Car {

    private Position position;

    private final CarName carName;

    public Car(final String carName) {
        this(DEFAULT_POSITION, carName);
    }

    public Car(final int position, final String carName) {
        this.position = new Position(position);
        this.carName = new CarName(carName);
    }

    public void move(final MovableStrategy movableStrategy) {
        if (movableStrategy.movable()) {
            this.position = position.increase();
        }
    }

    public boolean hasSamePosition(final int position) {
        return this.position.equals(new Position(position));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (!Objects.equals(position, car.position)) return false;
        return carName.equals(car.carName);
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + carName.hashCode();
        return result;
    }

    public Position getPosition() {
        return position;
    }

    public CarName getCarName() {
        return carName;
    }
}
