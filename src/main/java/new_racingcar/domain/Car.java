package new_racingcar.domain;

import new_racingcar.strategy.MoveStrategy;
import new_racingcar.constant.MsgConstants;

public class Car {
    private String name;
    private MoveStrategy moveStrategy;
    private int distance;

    public Car(String name, MoveStrategy moveStrategy) {
        this(name, moveStrategy, 0);
    }

    public Car(String name, MoveStrategy moveStrategy, int distance) {
        isNameValid(name);
        this.name = name;
        this.distance = distance;
        this.moveStrategy = moveStrategy;
    }

    public Car move() {
        if (moveStrategy.isMoveable()) {
            ++distance;
        }

        return new Car(name, moveStrategy, distance);
    }

    public Car move(MoveStrategy strategy) {
        setMoveStrategy(strategy);

        if (moveStrategy.isMoveable()) {
            ++distance;
        }

        return new Car(name, moveStrategy, distance);
    }

    private void setMoveStrategy(MoveStrategy strategy) {
        this.moveStrategy = strategy;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void isNameValid(String name) {
        if (name.length() > 5
                || name.trim().isEmpty()) {
            throw new IllegalArgumentException(MsgConstants.CAR_NAME_ERROR_MESSAGE);
        }
    }
}
