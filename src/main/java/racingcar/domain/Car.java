package racingcar.domain;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private Position position;

    private static final int DEFAULT_CAR_POSITION = 0;
    private static final int ACCEPT_MOVE_NUMBER = 4;

    public Car(final String carName) {
        this.carName = new CarName(carName);
        this.position = new Position(DEFAULT_CAR_POSITION);
    }

    public Car(final String carName, final int distance) {
        this.carName = new CarName(carName);
        this.position = new Position(distance);
    }

    private Car(final Car car) {
        this.carName = new CarName(car.carName.getCarName());
        this.position = new Position(car.position.getPosition());
    }

    public Position getCarPosition() {
        return position;
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public void tryMove(final int randomNumber) {
        if (randomNumber >= ACCEPT_MOVE_NUMBER) {
            position = position.move();
        }
    }

    public boolean isAtPosition(final Position maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    public static Car copyCar(final Car car) {
        return new Car(car);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

}
