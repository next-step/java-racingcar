package racingCar.domain;

public class Car {
    private static final int RUNNABLE_LIMIT_NUMBER = 4;

    private Distance distance;

    public Car() {}

    public Car(int distance) {
        this.distance = new Distance(distance);
    }

    public Distance moveForward(int randomNumber) {
        if (isRunnable(randomNumber)) {
             distance.moveForward();
        }
        return distance;
    }

    private boolean isRunnable(int randomNumber) {
        return randomNumber >= RUNNABLE_LIMIT_NUMBER;
    }
}
