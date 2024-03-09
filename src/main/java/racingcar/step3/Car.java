package racingcar.step3;

import racingcar.step3.move.MoveStrategy;

public class Car {

    private final MoveStrategy moveStrategy;
    private int location;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public int getCurrentLocation() {
        return this.location;
    }

    public void move() {
        location += moveStrategy.move();
    }
}
