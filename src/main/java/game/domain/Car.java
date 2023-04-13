package game.domain;

import game.domain.policy.CarMovePolicy;
import game.domain.policy.StandardCarMovePolicy;

public class Car {

    private final CarName carName;
    private final CarMovePolicy carMovePolicy;
    private final Position position;

    public Car(String carName) {
        this(carName, new StandardCarMovePolicy(), new Position(0));
    }

    public Car(String carName, CarMovePolicy carMovePolicy, Position position) {
        this.carName = new CarName(carName);
        this.carMovePolicy = carMovePolicy;
        this.position = position;
    }

    public void drive() {
        if (carMovePolicy.isMovable()) {
            position.forward();
        }
    }

    public Position getPosition() {
        return position;
    }

    public boolean isWinner(Position position) {
        return this.position.isSame(position);
    }

    public String getName() {
        return carName.getName();
    }
}