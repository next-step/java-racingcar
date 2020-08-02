package cc.oak.racing;

import cc.oak.racing.condition.CarForwardCondition;

public class Car {
    private int movedDistance;
    private final CarForwardCondition<?> carForwardCondition;

    public Car(CarForwardCondition<?> carForwardCondition) {
        this.carForwardCondition = carForwardCondition;
    }

    public void tryMoveForward() {
        if (carForwardCondition.isConvertedCarMeetCondition(this)) {
            moveForward();
        }
    }

    private void moveForward() {
        movedDistance++;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}
