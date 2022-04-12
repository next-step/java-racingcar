package racingcar;

public class Car {
    private static final int DEFAULT_STATE = 0;
    private int state;

    public Car() {
        state = DEFAULT_STATE;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            state++;
        }
    }

    public int state() {
        return state;
    }
}
