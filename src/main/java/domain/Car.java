package domain;

import java.util.Objects;
import strategy.MoveStrategy;
import strategy.RandomMoveStrategy;

public class Car {

    private CarName carName;
    private Position position;
    private MoveStrategy randomMoveStrategy;

    public Car(CarName carName, Position position, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.position = position;
        this.randomMoveStrategy = moveStrategy;
    }

    public Car(CarName carName, Position position) {
        this(carName, position, new RandomMoveStrategy());
    }

    public Car(String carName) {
        this(new CarName(carName), new Position());
    }

    public Car(String carName, int position) {
        this(new CarName(carName), new Position(position));
    }

    public CarName getCarName() {
        return this.carName;
    }

    public Position getPosition() {
        return this.position;
    }

    public void move() {
        if (randomMoveStrategy.isMovable()) {
            position.move();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(getCarName(), car.getCarName()) && Objects
            .equals(getPosition(), car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarName(), getPosition());
    }
}
