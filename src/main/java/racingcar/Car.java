package racingcar;

import java.util.StringJoiner;

public class Car {
    private static final int STEP_HURDLE = 4;

    private int position = 0;

    public void moveForward(int step) {
        if (step < STEP_HURDLE) {
            return;
        }
        position += step;
    }

    public int position() {
        return position;
    }

}
