package racingcar.domain;

public class Car {

    private final CarMoveCondition moveCondition;
    private int distance;

    public Car(CarMoveCondition moveStrategy) {
        this.moveCondition = moveStrategy;
        this.distance = 0;
    }

    public void move() {
        if (moveCondition.movable()) {
            distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

}
