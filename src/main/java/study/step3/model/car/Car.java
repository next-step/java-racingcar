package study.step3.model.car;

import study.step3.model.strategy.MoveStrategy;

public class Car {

    private int distance;
    private final MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this.distance = 0;
        this.moveStrategy = moveStrategy;
    }

    public int getDistance() {
        return distance;
    }

    private void moveCar() {
        distance++;
    }

    public void move(int randomNumber) {
        if(moveStrategy.isMoveCondition(randomNumber)) {
            moveCar();
        }
    }
}
