package racingcar;

public class Car {

    public static final int MINIMUM_NUMBER_FOR_MOVEMENT = 4;
    private int currentLocation = 0;

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void move(int input) {
        if (isMovable(input)) {
            this.currentLocation++;
        }
    }

    private boolean isMovable(int input) {
        return input > MINIMUM_NUMBER_FOR_MOVEMENT;
    }
}
