package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class Car {
    private final CarName carName;

    private Position position;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        this.carName = new CarName(carName);
        this.position = new Position(position);
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) {
            position = position.move();
        }
        return this;
    }
}
