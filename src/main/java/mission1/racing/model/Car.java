package mission1.racing.model;

import mission1.racing.RacingRandom;
import mission1.racing.view.RacingGameOutputView;

public class Car {
    private String name;
    private int carPositions;

    private RacingRandom random = new RacingRandom();

    public Car() {}
    public Car(String name) {
        this.name = name;
    }

    public void go() {
        int LIMIT = 4;

        if (random.random() >= LIMIT) {
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
}
