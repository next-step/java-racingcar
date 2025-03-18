package domain;

import policy.CarMovementPolicy;
import vo.CarPosition;

public class Car {

    private final CarPosition position;

    public Car(CarPosition position) {
        this.position = position;
    }

    public static Car create() {
        return new Car(CarPosition.initialize());
    }

    public int getPosition() {
        return this.position.getValue();
    }

    public void move(CarMovementPolicy policy) {
        if (policy.isMovable()) {
            this.position.move();
        }
    }
}
