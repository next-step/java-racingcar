package racingcar;

public class Car {
    private static final int DEFAULT_STATE = 0;
    private int state;

    Car() {
        state = DEFAULT_STATE;
    }

    public int getState() {
        return state;
    }
}
