package racinggame;

import racinggame.vo.CarState;

public class Car {
    private static final int INIT_POSITION = 0;

    private CarState carState;

    public Car(String name) {
        carState = new CarState(name, INIT_POSITION);
    }

    public void move(boolean movable) {
        if (movable) {
            carState = carState.move();
        }
    }

    public CarState currentState() {
        return carState;
    }
}
