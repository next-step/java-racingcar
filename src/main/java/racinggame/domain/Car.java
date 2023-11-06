package racinggame.domain;

import racinggame.strategy.MoveStrategy;

public class Car {

    public static final String OUTPUT_CAR_COLON = " : ";
    private static final int MOVE_CAR_CONDITION = 4;

    private Name carName;
    private int position;
    private MoveStrategy moveStrategy;

    public Car(String carName, MoveStrategy moveStrategy) {
        this.carName = new Name(carName);
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

    @Override
    public String toString() {
        return carName + OUTPUT_CAR_COLON;
    }

}
