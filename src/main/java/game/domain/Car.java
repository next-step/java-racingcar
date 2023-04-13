package game.domain;

import game.domain.policy.CarMovePolicy;
import game.domain.policy.StandardCarMovePolicy;

public class Car {

    private final CarName carName;
    private final CarMovePolicy carMovePolicy;

    private int position = 0;

    public Car(String carName) {
        this(carName, new StandardCarMovePolicy());
    }

    public Car(String carName, CarMovePolicy carMovePolicy) {
        this.carName = new CarName(carName);
        this.carMovePolicy = carMovePolicy;
    }

    public void drive() {
        if (carMovePolicy.isMovable()) {
            position++;
        }
    }

    public int position() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String name() {
        return carName.getName();
    }
}