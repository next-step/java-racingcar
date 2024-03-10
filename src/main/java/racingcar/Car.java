package racingcar;

public class Car {

    private int distance;
    private final CarMoveCondition moveCondition;

    public Car(CarMoveCondition moveCondition) {
        this.distance = 0;
        this.moveCondition = moveCondition;
    }

    public int move(int value) {
        return moveCondition.isMovable(value) ? ++distance : distance;
    }

}
