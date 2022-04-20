package racingcar.domain;

import racingcar.MovingStrategy;

public class Car {

    private static final int START_LOCATION = 1;
    private int currentLocation;
    private final String carName;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        this.carName = carName;
        this.movingStrategy = movingStrategy;
        this.currentLocation = START_LOCATION;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void move(int input) {
        if (movingStrategy.isMovable(input)) {
            this.currentLocation++;
        }
    }

    public String getCarName() {
        return carName;
    }
}
