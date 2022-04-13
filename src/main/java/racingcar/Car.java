package racingcar;

public class Car {

    private static final int START_LOCATION = 1;
    private int currentLocation;
    private final MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy) {
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
}
