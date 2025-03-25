package step5.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final CarName carName;
    private Position position;

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public Car(CarName carName) {
        this.carName = carName;
        this.position = new Position(0);
    }

    public Car(Position position) {
        this.carName = new CarName("name");
        this.position = position;
    }

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position(0);
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position = position.move();
        }
    }

    public String getRawName() {
        return this.carName.getCarName();
    }
    public int getRawPosition() {
        return this.position.getPosition();
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

    @Override
    public int compareTo(Car other) {
        return this.position.compareTo(other.position);
    }
}
