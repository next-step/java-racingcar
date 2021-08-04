package study.step3.model.car;

import study.step3.model.strategy.MoveStrategy;

public class Car {

    private int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    private void moveCar() {
        distance++;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMoveCondition()) {
            moveCar();
        }
    }
}
