package racingcar;

import java.util.List;

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

    public void move(List<Integer> generatedNumbers) {
        long movableCount = generatedNumbers.stream()
                .filter(this::isMovable)
                .count();

        this.currentLocation += movableCount;
    }

    private boolean isMovable(int input) {
        return input > MINIMUM_NUMBER_FOR_MOVEMENT;
    }
}
