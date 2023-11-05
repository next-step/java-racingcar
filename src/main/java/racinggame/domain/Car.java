package racinggame.domain;

import racinggame.strategy.MoveStrategy;

public class Car {

    private static final int MOVE_CAR_CONDITION = 4;

    private int position;
    private Name carName;
    private MoveStrategy moveStrategy;

    public Car(Name carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.moveStrategy = moveStrategy;
    }

    public void moving() {
        if (moveStrategy.number() >= MOVE_CAR_CONDITION) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public Name getCarName() {
        return carName;
    }

}
