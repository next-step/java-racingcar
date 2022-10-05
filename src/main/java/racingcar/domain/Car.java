package racingcar.domain;

import static racingcar.domain.RandomNumber.isNotLessThanThreshold;

public class Car {
    private int position = 0;

    public void moveForward(int movableThreshold) {
        if (isMovable(movableThreshold)) {
            position++;
        }
    }

    private boolean isMovable(int movableThreshold) {
        return isNotLessThanThreshold(movableThreshold);
    }

    public int getPosition() {
        return position;
    }
}
