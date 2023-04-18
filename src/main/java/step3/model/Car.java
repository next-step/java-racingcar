package step3.model;

import step3.utils.RacingUtils;

public class Car {
    private static final int RANDOM_NUMBER_LIMIT = 4;
    private int distance;

    public Car(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance() {
        distance++;
    }

    public void availableForward(int randomNumber) {
        if (RacingUtils.isOverLimit(randomNumber)) {
            this.increaseDistance();
        }
    }
}
