package racingcar.domain;

public class Car {
    static final int CRITERION_FOR_MOVING = 4;

    private int location = 0;

    public int getLocation() {
        return location;
    }

    void goForward() {
        location++;
    }

    boolean isAbleToMove(int value) throws IllegalArgumentException {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("invalid argument for isAbleToMove : " + value);
        }

        return value >= CRITERION_FOR_MOVING;
    }

    void move(int value) {
        if (isAbleToMove(value)) {
            goForward();
        }
    }
}
