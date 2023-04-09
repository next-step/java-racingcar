package domain;

import static domain.RandomNumber.isOverFour;

public class Car {

    private int distance;

    public Car() {
    }

    public int getCarCurrentDistance() {
        return distance;
    }

    static boolean movingCheck() {
        return isOverFour();
    }

    void attemptMove() {
        if (movingCheck()) {
            distance++;
        }
    }
}
