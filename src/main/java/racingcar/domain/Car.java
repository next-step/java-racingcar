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

    public Car(final Car car) {
        this.carName = car.carName;
        this.position = car.position;
    }

    public int getCarPosition() {
        return position.getPosition();
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public Car tryMove(final int randomNumber) {
        if (randomNumber >= ACCEPT_MOVE_NUMBER) {
            position = position.move();
        }

        return new Car(this.getCarName(), position.getPosition());
    }

    public boolean isAtMaxPosition(final int maxPosition) {
        return position.getPosition() == maxPosition;
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
