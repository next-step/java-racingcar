package racing.domain;

import racing.CarStatement;
import racing.domain.strategy.DrivingStrategy;

public class Car {
    private final CarStatement state;

    private Car(CarStatement state) {
        this.state = state;
    }

    public static Car of(String name) {
        CarStatement state = new CarStatement(name);
        return new Car(state);
    }

    public void goOrNot(DrivingStrategy strategy) {
        if (strategy.isMovable()) {
            go();
        }
    }

    private void go() {
        state.move();
    }

    public String getName() {
        return state.getName();
    }

    public int getPosition() {
        return state.getPosition();
    }

    public int max(int max) {
        return state.max(max);
    }
}