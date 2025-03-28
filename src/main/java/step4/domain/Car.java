package step4.domain;

import java.util.Comparator;
import java.util.Objects;

public class Car {
    private final CarName carName;
    private Position position;
    public static final int DEFAULT_POSITION = 0;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new Position(DEFAULT_POSITION);
    }

    public Car(String carName, int position) {
        this.carName = new CarName(carName);
        this.position = new Position(position);
    }


    public String getCarName() { return  this.carName.getCarName(); }

    public int getPosition() {
        return this.position.getPosition();
    }

    public void move(MoveStrategy moveStrategy) {
        if (!moveStrategy.isMovable()) return;
        this.position.move();
    }

    public static final Comparator<Car> POSITION_COMPARATOR = Comparator.comparingInt(Car::getPosition);

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
