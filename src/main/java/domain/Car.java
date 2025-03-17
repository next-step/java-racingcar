package domain;

import policy.RacingCarPolicy;
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

    public void move() {
        if (RacingCarPolicy.isMovable()) {
            this.position.move();
        }
    }
}
