package racingcar.domain;

import static racingcar.domain.RandomNumber.isNotLessThanThreshold;

public class Car {
    private int position = 0;

    private final String name;

    private Car(String name) {
        this.name = name;
    }

    public static Car nameOf(String name) {
        return new Car(name);
    }

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
