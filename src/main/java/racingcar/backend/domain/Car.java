package racingcar.backend.domain;

import racingcar.backend.strategy.MoveStrategy;

public class Car {

    private CarName carName;
    private Position position;

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public static Car create(CarName carName) {
        return new Car(carName, Position.create(0));
    }

    public static Car create(CarName carName, Position position) {
        return new Car(carName, position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position.forward();
        }
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return carName.getValue();
    }
}
