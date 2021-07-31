package racingCar.model;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private Position position;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position();
    }

    public Position move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.position = position.move();
        }
        return position;
    }

    public String getName() {
        return carName.getCarName();
    }

    public int getPosition(){
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
