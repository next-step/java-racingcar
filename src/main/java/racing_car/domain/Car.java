package racing_car.domain;

import racing_car.common.ErrorMessage;
import racing_car.domain.strategy.MoveStrategy;

public class Car {

    private int location;
    private final String name;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME);
        }
        if (name.length() >= 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME);
        }
        if (moveStrategy == null) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_MOVE_STRATEGY);
        }
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.move()) {
            goForward();
        }
    }

    private void goForward() {
        location++;
    }

    public int getLocation() {
        return location;
    }

    public Record exportRecord() {
        return new Record(this.name, this.location);
    }

}
