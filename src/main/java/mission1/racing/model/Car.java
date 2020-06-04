package mission1.racing.model;

import mission1.racing.RacingRandom;
import mission1.racing.view.RacingGameOutputView;

public class Car {
    private String name;
    private int carPositions;
    private final int LIMIT = 4;

    public Car(String name) {
        this.name = name;
    }

    public Car(int position) {
        this.carPositions = position;
    }

    public void go(int randomValue) {
        if (moveCondition(randomValue)) {
            carPositions++;
        }
    }

    public boolean isWinner(int maxPosition) {
        return carPositions == maxPosition;
    }

    public int getCarPositions() {
        return carPositions;
    }

    public String getName() {
        return name;
    }

    private boolean moveCondition(int randomValue) {
        return randomValue >= LIMIT;
    }
}
