package step3.domain;

import step3.view.ResultView;

public class Car {
    private static final int STARTING_POINT = 0;
    private static final int RUNNABLE_LIMIT_NUMBER = 4;
    private int distance;

    public Car() {
        this.distance = STARTING_POINT;
    }

    public Car(int distance) {
        this.distance = distance;
    }

    public int moveForward(int randomNumber) {
        if (isRunnable(randomNumber)) {
            distance++;
        }
        return distance;
    }

    private boolean isRunnable(int randomNumber) {
        return (randomNumber >= RUNNABLE_LIMIT_NUMBER) ? Boolean.TRUE : Boolean.FALSE;
    }
}
