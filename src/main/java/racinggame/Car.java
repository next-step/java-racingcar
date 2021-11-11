package racinggame;

public class Car {
    private static final int INIT_POSITION = 0;

    private final CarState carState;

    public Car(String name) {
        carState = new CarState(name, INIT_POSITION);
    }

    public void move(boolean movable) {
        if (movable) {
            carState.move();
        }
    }

    public int currentPosition() {
        return carState.currentPosition();
    }

    public CarState currentState() {
        return carState;
    }
}
