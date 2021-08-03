package racingCar.model;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private Position position;

    public Car(final String carName) {
        this(carName, 0);
    }

    public Car(final String carName, int position) {
        this.carName = new CarName(carName);
        this.position = new Position(position);
    }

    public Position move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.position = position.move();
        }
        return position;
    }

    public boolean samePosition(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public Position getMaxPosition(Position maxPosition) {
        if (position.lessThan(maxPosition.getPosition())) {
            return maxPosition;
        }
        return this.position;
    }

    public String getName() {
        return carName.value();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

}
