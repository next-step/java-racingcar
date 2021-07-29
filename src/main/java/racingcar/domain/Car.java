package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class Car {
    private Position position;
    private CarName carName;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = new Position();
    }

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public CarName getName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position.move();
        }
    }
}
