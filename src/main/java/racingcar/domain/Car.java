package racingcar.domain;

public class Car {
    private final static int START_LOCATION = 0;
    private final static int MOVE_STRATEGY = 1;
    private int currentLocation;

    public Car() {
        this.currentLocation = START_LOCATION;
    }

    public Car(Car car) {
        this.currentLocation = car.currentLocation;
    }

    public Car(int location) {
        this.currentLocation = location;
    }

    public void move(Boolean isMove) {
        if (isMove) {
            this.currentLocation = currentLocation + MOVE_STRATEGY;
        }
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

}
