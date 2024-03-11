package racingcar;

import racingcar.exception.CarNegativeDistanceException;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int move(int value) {
        return CarMoveCondition.isMovable(value) ? move() : stop();
    }

    private int move() {
        return ++distance;
    }

    private int stop() {
        return distance;
    }

    public String toString() {
        validateNegativeDistance();
        return "-".repeat(distance);
    }

    private void validateNegativeDistance() {
        if (distance < 0) {
            throw new CarNegativeDistanceException();
        }
    }

}
