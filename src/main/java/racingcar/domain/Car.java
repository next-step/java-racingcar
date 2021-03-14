package racingcar.domain;

public class Car {

    private final static int START_LOCATION = 0;
    private final static int MOVE_STRATEGY = 1;
    private int currentLocation;

    public Car() {
        currentLocation = START_LOCATION;
    }

    public void move(Boolean isMove) {
        if (isMove) {
            currentLocation = currentLocation + MOVE_STRATEGY;
        }
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public Car(int location) {
        currentLocation = location;
    }


}
